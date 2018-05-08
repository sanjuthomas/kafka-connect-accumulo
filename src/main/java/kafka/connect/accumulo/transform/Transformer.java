package kafka.connect.accumulo.transform;

import org.apache.kafka.connect.sink.SinkRecord;

import kafka.connect.accumulo.Row;

public interface Transformer {
    
    Row transform(SinkRecord sinkRecord);

}
