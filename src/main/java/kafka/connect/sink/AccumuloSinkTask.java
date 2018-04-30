package kafka.connect.sink;

import java.util.Collection;
import java.util.Map;

import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kafka.connect.sink.accumulo.BufferedWriter;
import kafka.connect.sink.accumulo.Writer;

/**
 * 
 * @author Sanju Thomas
 *
 */
public class AccumuloSinkTask extends SinkTask {
	
	private static final Logger logger = LoggerFactory.getLogger(AccumuloSinkTask.class);
	private Writer writer;

	public String version() {
		return ".1";
	}

	@Override
	public void put(final Collection<SinkRecord> records) {
		 Observable.fromIterable(records)
		 .flatMapCompletable(new Function<SinkRecord, Completable>() {
			public Completable apply(final SinkRecord r) throws Exception {
				writer.write(records);
				return null;
			}
		 }).retry(1).blockingAwait();
	}

	@Override
	public void start(final Map<String, String> arg0) {
		logger.info("start called!");
		this.writer = new BufferedWriter();
	}

	@Override
	public void stop() {
		 logger.info("stop called!");
	}

}
