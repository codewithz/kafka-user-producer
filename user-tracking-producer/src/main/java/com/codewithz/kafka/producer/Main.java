package com.codewithz.kafka.producer;


import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.codewithz.kafka.producer.model.Event;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
    	
    	EventGenerator eventGenerator=new EventGenerator();
    	
    	Properties props=new Properties();
    	props.put("bootstrap.servers","localhost:9092");
    	 props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
         props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
         props.put("schema.registry.url", "http://localhost:8081");

    	
    	
    	Producer<String, String> producer=new KafkaProducer<>(props);
    	
    	String topic="user-tracking-avro";
    	
    	for(int i=1;i<=10;i++) {
    		
    		System.out.println("Event No #"+i);
    		
    		Event event=eventGenerator.generateEvent();
    		
    		String key=extractKey(event);
    		String value=extractValue(event);
    		
    		ProducerRecord<String, String> record=new ProducerRecord<String, String>(topic, key, value);
    		
    		producer.send(record);
    		
    		Thread.sleep(1000);
    	}
    	
    	producer.close();

    }
    
    private static String extractKey(Event event) {
        return event.getUser().getUserId().toString();
    }

    private static String extractValue(Event event) {
        return String.format("%s,%s,%s", event.getProduct().getType(), event.getProduct().getColor(), event.getProduct().getDesignType());
    }



}
