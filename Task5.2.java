/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */

import java.util.HashSet;

import java.time.Instant;
import java.util.Optional;
public class Extract {

	

	public static Timespan getTimespan(List<Tweet> tweets) {
	    if (tweets.isEmpty()) {
	        return new Timespan(Instant.now(), Instant.now()); // Handle empty case
	    }

	    Instant start = tweets.stream()
	                          .map(Tweet::getTimestamp)
	                          .min(Instant::compareTo)
	                          .orElse(Instant.now());

	    Instant end = tweets.stream()
	                        .map(Tweet::getTimestamp)
	                        .max(Instant::compareTo)
	                        .orElse(Instant.now());

	    return new Timespan(start, end);
	}

	   public static Set<String> getMentionedUsers(List<Tweet> tweets) {
	        Set<String> mentionedUsers = new HashSet<>();

	        for (Tweet tweet : tweets) {
	            String text = tweet.getText();
	            String[] words = text.split("\\s+");
	            for (String word : words) {
	                if (word.startsWith("@")) {
	                    String username = word.substring(1);
	                    // Check if username is valid
	                    if (username.length() > 0 && username.length() <= 15 && username.matches("[A-Za-z0-9_]+")) {
	                        mentionedUsers.add(username.toLowerCase()); // Store usernames in lowercase
	                    }
	                }
	            }
	        }
	        return mentionedUsers;
	    }


}




















