package TestPartition;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;

public class Listener implements ConsumerRebalanceListener{
    private double startTime;
    private double endTime;
    private double execTime;
    private String consumerID;
    Listener(Args argument){
        this.consumerID = argument.consumerID;
    }
    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions){
        endTime = System.currentTimeMillis();
        System.out.println("finish rebalanced");
        calculateExecuteTime();
    }

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions){
        startTime = System.currentTimeMillis();
        System.out.println("Rebalanced gogo");
    }

    public void calculateExecuteTime(){
        execTime = (endTime - startTime)/1000;
        System.out.println(this.consumerID + "execution time = " + execTime);
    }


}
