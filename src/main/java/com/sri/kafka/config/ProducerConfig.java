package com.sri.kafka.config;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.sri.twitter.config.TwitterConfig;
import com.sri.twitter.utilities.TwitterUtilities;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class ProducerConfig {

	public static void main(String[] args) throws TwitterException {

		// configuration

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		// producer
		Producer<String, String> producer = new KafkaProducer<String, String>(props);

		// produce

		// twitter instances

		TwitterConfig twitconfig = new TwitterConfig();

		Twitter twitter = twitconfig.getTwitterInstance();

		TwitterUtilities tut = new TwitterUtilities();
		List<String> timeLine = tut.getTimeLine(twitter);

//		timeLine.stream().forEach(System.out::println);

		for (String s : timeLine) {

			producer.send(new ProducerRecord<String, String>("twitter", s));
		}

		producer.close();

	}
}
