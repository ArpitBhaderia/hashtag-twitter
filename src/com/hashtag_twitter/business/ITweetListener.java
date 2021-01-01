package com.hashtag_twitter.business;

import java.io.IOException;
import java.util.List;

import com.hashtag_twitter.model.Tweet;

public interface ITweetListener {
	
	 List<Tweet> getAllTweets(String filePath) throws IOException;
	
}
