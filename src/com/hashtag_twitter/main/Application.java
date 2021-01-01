package com.hashtag_twitter.main;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hashtag_twitter.business.IHashtagListener;
import com.hashtag_twitter.business.ITweetListener;
import com.hashtag_twitter.business.impl.HashtagListenerImpl;
import com.hashtag_twitter.business.impl.TweetListenerImpl;
import com.hashtag_twitter.model.Hashtag;
import com.hashtag_twitter.model.Tweet;

public class Application {

	public static void main(String[] args) throws IOException {

		ITweetListener tweetListener = new TweetListenerImpl();
		IHashtagListener hashtagListener = new HashtagListenerImpl();

		List<Tweet> listOfTweets = tweetListener.getAllTweets();

		List<Hashtag> listOfHashtags = hashtagListener.extractAllHashtagsFromSingleTweet(listOfTweets);

		Map<Hashtag, Integer> hashtagsMap = hashtagListener.saveHashtags(listOfHashtags);

		for(Map.Entry<Hashtag, Integer> entry : hashtagsMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		List<Hashtag> listOfTrendingHashtags = hashtagListener.getTopTenTrendingHashtags(hashtagsMap);

		for(Hashtag hashtag : listOfTrendingHashtags) 
			System.out.println(hashtag.getHashtag());

		List<Entry<Hashtag, Integer>> listOfAllHashtags = hashtagListener.getAllUniqueHashtags(hashtagsMap);

		for(Entry<Hashtag, Integer> entry : listOfAllHashtags) 
			System.out.println(entry.getKey());

	}
}
