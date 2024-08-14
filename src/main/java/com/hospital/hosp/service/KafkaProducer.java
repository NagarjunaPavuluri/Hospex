package com.hospital.hosp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    public void produce(Object a){
        kafkaTemplate.send("tp", a).whenComplete((data, ex)->{
            System.out.println(data.getRecordMetadata().offset());
        });
    }
}
