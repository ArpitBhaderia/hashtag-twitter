package com.hashtag_twitter.business.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hashtag_twitter.business.IHashtagListener;
import com.hashtag_twitter.model.Hashtag;
import com.hashtag_twitter.model.Tweet;
import com.hashtag_twitter.utils.Utils;

public class HashtagListenerImpl implements IHashtagListener{

	@Override
	public List<Hashtag> extractAllHashtagsFromSingleTweet(List<Tweet> listOfTweets) throws IOException {
		
		System.out.println("==================extractAllHashtagsFromSingleTweet method called==================");

		List<Hashtag> listOfHashtags = new ArrayList<Hashtag>();

		for(Tweet tweet : listOfTweets) {
			Pattern pattern = Pattern.compile("#(\\S+)");
			Matcher mat = pattern.matcher(tweet.getTweet());

			while (mat.find()) {
				listOfHashtags.add(new Hashtag(mat.group()));
			}
		}
		return listOfHashtags;
	}

	@Override
	public Map<Hashtag, Integer> saveHashtags(List<Hashtag> listOfHashtags) {
		
		System.out.println("==================saveHashtags method called==================");

		Map<Hashtag, Integer> map= new HashMap<Hashtag, Integer>();

		for(Hashtag hashtag : listOfHashtags) {

			if(map.containsKey(hashtag)) 
				map.put(hashtag, map.get(hashtag) + 1);
			else
				map.put(hashtag, 1);
		}
		return map;
	}

	@Override
	public List<Hashtag> getTopTenTrendingHashtags(Map<Hashtag, Integer> hashtagsMap) {
		
		System.out.println("==================getTopTenTrendingHashtags method called==================");

		List<Hashtag> listOfHashtags = new ArrayList<Hashtag>();

		int count = 0;
		for(Map.Entry<Hashtag, Integer> entry : Utils.entriesSortedByValues(hashtagsMap)) {
			if(count == 10) break;
			listOfHashtags.add(entry.getKey());
			count++;
		}

		return listOfHashtags;
	}

	@Override
	public List<Entry<Hashtag, Integer>> getAllUniqueHashtags(Map<Hashtag, Integer> hashtagsMap) {
		
		System.out.println("==================getAllUniqueHashtags method called==================");
		return Utils.entriesSortedByValues(hashtagsMap);
	}




}
