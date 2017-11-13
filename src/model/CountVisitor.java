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
        System.out.println("visitUser:" + userCount);
        ++userCount;
    }

    public void visitUserGroup() {
        System.out.println("visitUserGroup:" + groupCount);
        ++groupCount;
    }

    public void visitTweet() {
        System.out.println("visitTweet:" + tweetCount);
        ++tweetCount;
    }

    public void visitPositiveTweet() {
        System.out.println("visitPositiveTweet:" + posTweetCount);
        ++posTweetCount;
    }

    public int getUserCount() {
        System.out.println("getUserCount:" + userCount);
        return userCount;
    }

    public int getGroupCount() {
        System.out.println("getGroupCount:" + groupCount);
        return groupCount;
    }

    public int getTweetCount() {
        System.out.println("getTweetCount:" + tweetCount);
        return tweetCount;
    }

    public int getPosTweetCount() {
        System.out.println("getPosTweetCount");
        return tweetCount == 0 ? 0 : 100 * posTweetCount / tweetCount;
    }
}