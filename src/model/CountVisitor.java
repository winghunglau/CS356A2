package model;

/**
 * This is the CountVisitor class.
 * It is used to keep track of the total number of user, group,
 * tweet, and the percentage of positive tweet.
 */
public class CountVisitor implements ElementVisitor {
	
    private static CountVisitor countVisitor = null;
    private int userCount = 0;
    private int groupCount = 0;
    private int tweetCount = 0;
    private int posTweetCount = 0;

    private CountVisitor(){};

    public static CountVisitor getInstance() {
        if(countVisitor == null) {
            countVisitor = new CountVisitor();
        }
        return countVisitor;
    }	

    public void visitUser() {
        ++userCount;
    }

    public void visitUserGroup() {
        ++groupCount;
    }

    public void visitTweet() {
        ++tweetCount;
    }

    public void visitPositiveTweet() {
        ++posTweetCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public int getTweetCount() {
        return tweetCount;
    }

    public int getPosTweetCount() {
        return 100 * posTweetCount / tweetCount;
    }
}