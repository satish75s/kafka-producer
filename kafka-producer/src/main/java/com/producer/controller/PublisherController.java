package com.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-publisher")
public class PublisherController {

	private String TOPIC = "NewTopic";

	@Autowired
	private KafkaTemplate<String, Object> template;

	@GetMapping("/publish/{input}")
	public String publishMessage(@PathVariable String input) {
		template.send(TOPIC, "Hi  " + input + " Welcome to kafka Producer World");
		return "Data published";
	}

}