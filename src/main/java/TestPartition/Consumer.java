package TestPartition;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;


public class Consumer extends Thread{

    public static void main(String[] args) {
        Properties props = new Properties();
        Args argument = Args.parse(args);
        Configure conf = new Configure(argument);


        conf.setProperty(props);
        //MultiConsumer multiConsumer=new MultiConsumer(props,argument);
        //multiConsumer.start();

        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props);
        Listener listener = new Listener(argument,consumer);
        consumer.subscribe(Arrays.asList("test25","test24","test23","test22","test21","test20","test19","test18","test17","test16","test15","test14","test13","test12","test11","test10","test9","test8","test7","test6","test5","test4","test3","test2","test1"), listener);
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("offset = "+record.offset() + " key = " + record.key() + " value = "+ record.value());
            }
        }

    }

}
