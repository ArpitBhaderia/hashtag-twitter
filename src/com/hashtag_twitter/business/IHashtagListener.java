package com.hashtag_twitter.business;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hashtag_twitter.model.Hashtag;
import com.hashtag_twitter.model.Tweet;

public interface IHashtagListener {

	List<Hashtag> extractAllHashtagsFromSingleTweet(List<Tweet> listOfTweets) throws IOException;

	Map<Hashtag, Integer> saveHashtags(List<Hashtag> listOfHashtags);

	List<Hashtag> getTopTenTrendingHashtags(Map<Hashtag, Integer> hashtagsMap);

	List<Entry<Hashtag, Integer>> getAllUniqueHashtags(Map<Hashtag, Integer> hashtagsMap);
}
