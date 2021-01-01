package com.hashtag_twitter.model;

public class Tweet {

	private String tweet;

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public Tweet(String tweet) {
		super();
		this.tweet = tweet;
	}

	public Tweet() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tweet == null) ? 0 : tweet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (tweet == null) {
			if (other.tweet != null)
				return false;
		} else if (!tweet.equals(other.tweet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tweet [tweet=" + tweet + "]";
	}

	
}
