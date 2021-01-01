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

public class TweetListenerImpl implements ITweetListener {

	@Override
	public List<Tweet> getAllTweets(String filePath) throws IOException {
		
		System.out.println("==================getAllTweets method called==================");

		

		File file = new File(filePath) ;  
		InputStream inputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		List<Tweet> list = bufferedReader.lines().map(tweet -> new Tweet(tweet)).collect(Collectors.toList());
		bufferedReader.close();
		
		return list;	
	}
}
