package com.sri.twitter.utilities;

import java.util.List;
import java.util.stream.Collectors;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterUtilities {

	public List<String> getTimeLine(Twitter twitter) throws TwitterException {
//	    Twitter twitter = getTwitterinstance();

		return twitter.getHomeTimeline().stream().map(item -> item.getText()).collect(Collectors.toList());
	}
}
