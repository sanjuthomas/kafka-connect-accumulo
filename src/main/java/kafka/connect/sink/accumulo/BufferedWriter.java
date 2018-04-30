package kafka.connect.sink.accumulo;

import java.util.Collection;

import org.apache.kafka.connect.errors.RetriableException;
import org.apache.kafka.connect.sink.SinkRecord;

/**
 * 
 * @author Sanju Thomas
 *
 */
public class BufferedWriter implements Writer{

	public void write(final Collection<SinkRecord> records) {
		
		throw new RetriableException("test");
	}

}
