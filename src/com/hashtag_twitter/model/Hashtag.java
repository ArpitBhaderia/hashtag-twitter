package com.hashtag_twitter.model;

public class Hashtag {
	
	private String hashtag;

	public Hashtag(String hashtag) {
		super();
		this.hashtag = hashtag;
	}

	public Hashtag() {
		super();
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashtag == null) ? 0 : hashtag.hashCode());
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
		Hashtag other = (Hashtag) obj;
		if (hashtag == null) {
			if (other.hashtag != null)
				return false;
		} else if (!hashtag.equals(other.hashtag))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hashtag [hashtag=" + hashtag + "]";
	}
	
}
