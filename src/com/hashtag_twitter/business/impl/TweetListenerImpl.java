package com.hashtag_twitter.business.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import com.hashtag_twitter.business.ITweetListener;
import com.hashtag_twitter.model.Tweet;
import com.hashtag_twitter.utils.Constants;

public class TweetListenerImpl implements ITweetListener {

	@Override
	public List<Tweet> getAllTweets() throws IOException {
		
		System.out.println("==================getAllTweets method called==================");

		String filePath = System.getProperty("user.dir") + File.separator + 
				Constants.LIB_PATH + File.separator + Constants.TWEET_FILE_PATH;

		File file = new File(filePath) ;  
		InputStream inputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		List<Tweet> list = bufferedReader.lines().map(tweet -> new Tweet(tweet)).collect(Collectors.toList());
		bufferedReader.close();
		
		return list;	
	}
}
