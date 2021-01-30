package com.sri.twitter.config;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfig {

	public static void main(String[] args) throws TwitterException {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("i4Dy8qCECbdRrGzqawBTdPY84")
				.setOAuthConsumerSecret("ILb4iXmmS1zrpN61ANTAFa3ypvdTuJS9SRt40SxBUUXRZTBHyf")
				.setOAuthAccessToken("2204774772-46qSKOv4X1fQpncMBjouF3uDztwHrxtLwv0YJns")
				.setOAuthAccessTokenSecret("bM6rzlUguUdFBzlT3jWFIH4etOp4csx3ntVp8tdrS1GK3");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

//		ResponseList<Status> favorites = twitter.getFavorites();

//		TwitterUtilities twitterUtilites = new TwitterUtilities();
//
//		List<String> timeLine = twitterUtilites.getTimeLine(twitter);
//
//		System.out.println("Here is the size" + timeLine.size());

	}

	public Twitter getTwitterInstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("your consumer key").setOAuthConsumerSecret("your consumer secret")
				.setOAuthAccessToken("your access token").setOAuthAccessTokenSecret("your access token secret");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
	}

//	public List<String> getTimeLine(Twitter twitter) throws TwitterException {
////	    Twitter twitter = getTwitterinstance();
//
//		return twitter.getHomeTimeline().stream().map(item -> item.getText()).collect(Collectors.toList());
//	}
}
