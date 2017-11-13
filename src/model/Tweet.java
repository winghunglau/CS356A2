package model;

import java.util.*;

/**
 * This is the Tweet class.
 * It includes all the information and actions of a tweet message.
 */

public class Tweet {

    private static Set<String> positiveWords = new HashSet<String> (Arrays.asList("happy", "nice", "awesome", "excellent", "good", "great"));
    private String tweet;
    private User author;

    public Tweet(String tweet, User author) {
        CountVisitor countVisitor = CountVisitor.getInstance();
        countVisitor.visitTweet();
        this.tweet = tweet;
        this.author = author;
        String[] words = tweet.split(" ");    
        for (String w : words) {
            if(positiveWords.contains(w)) {
                countVisitor.visitPositiveTweet();
            }
        }
    }

    public String getTweet() {
        return tweet;
    }

    public User getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return tweet + " - by " + author;
    }
}