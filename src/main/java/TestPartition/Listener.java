package TestPartition;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class Listener implements ConsumerRebalanceListener{
    private double startTime;
    private double endTime;
    private double execTime;
    private String consumerID;
    private KafkaConsumer<String, String> consumer;
    private String recordTime;

    Listener(Args argument,KafkaConsumer<String, String> consumer){
        this.consumerID = argument.consumerID;
        this.consumer=consumer;
    }
    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions){
        consumer.seekToBeginning(partitions);
        endTime = System.currentTimeMillis();
        System.out.println("finish rebalanced");
        calculateExecuteTime();
    }

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions){
        startTime = System.currentTimeMillis();
        System.out.println("Rebalanced start");
    }

    public void calculateExecuteTime(){
        execTime = (endTime - startTime)/1000;
        recordTime = this.consumerID + "'s execution time of rebalanced = " + execTime;
        System.out.println(recordTime);
    }
    public void writeTimeIntoFile(String context) throws IOException {
        LocalDateTime date = LocalDateTime.now();
        File fileName = new File("/home/harry/Desktop/"+date+".txt");
        fileName.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(context+"\r\n");
        writer.flush();
        writer.close();
    }

}
