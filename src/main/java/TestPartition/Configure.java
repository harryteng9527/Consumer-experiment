package TestPartition;

import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;

public class Configure {
    private final String bootstrapServer;
    private final String groupID;
    private final String partitionStrategy;

    Configure(Args arg){
        this.bootstrapServer = arg.bootstrapServer;
        this.groupID = arg.groupID;
        this.partitionStrategy = arg.partitionStrategy;
    }

    public void setProperty(Properties props){
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,this.groupID);
        props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG,this.partitionStrategy);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
    }
}
