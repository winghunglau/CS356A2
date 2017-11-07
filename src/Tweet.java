import java.util.*;

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
	
}