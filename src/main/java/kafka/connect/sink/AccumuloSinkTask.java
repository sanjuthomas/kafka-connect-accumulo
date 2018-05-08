package kafka.connect.sink;

import java.util.Collection;
import java.util.Map;

import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Flowable;
import kafka.connect.accumulo.writer.BufferedWriter;
import kafka.connect.accumulo.writer.Writer;

/**
 * 
 * @author Sanju Thomas
 *
 */
public class AccumuloSinkTask extends SinkTask {
	
	private static final Logger logger = LoggerFactory.getLogger(AccumuloSinkTask.class);
	private Writer writer;

	@Override
    public String version() {
		return ".1";
	}

	@Override
	public void put(final Collection<SinkRecord> records) {
	    
	    Flowable.fromIterable(records).flatMapCompletable(record -> {
	        
	        return null;
	    });
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
