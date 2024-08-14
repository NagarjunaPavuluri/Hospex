package com.hospital.hosp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class kafkaListner {

    @KafkaListener(topicPartitions = @TopicPartition(
            topic = "tp",
            partitions = {"0"}
            /*partitionOffsets = {
                    @PartitionOffset(partition = "0",initialOffset = "earliest"),
                    @PartitionOffset(partition = "1",initialOffset = "earliest")
            }*/
    ),groupId = "group_id")
    public void listin(List<String> message){

        System.out.println(message);
    }
}
