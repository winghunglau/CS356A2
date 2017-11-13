package model;

import java.util.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * This is the User class.
 * It includes all the information and actions of a user.
 */
public class User implements Component, Observer{
	
    private int id;
    private String name;
    private List<Integer> followers;
    private List<Integer> followings;
    private List<Tweet> tweets;
    private UserGroup group;
    private NewsFeed newsFeed;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        followers = new ArrayList<Integer>();
        followings = new ArrayList<Integer>();
        tweets = new ArrayList<Tweet>();
        newsFeed = new NewsFeed();
        addFollower(this);
    }

    @Override 
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public void add(Component c) {
        System.out.println("Cannot add another user to User.");
    }

    @Override
    public void update(Tweet tweet) {
        tweets.add(tweet);
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public List<Integer> getFollowings() {
        return followings;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void follow(int id) {
        followings.add(id);
    }

    public void addFollower(User user) {
        newsFeed.attach(user);
        followers.add(user.getID());
        user.follow(this.getID());
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }

    public UserGroup getGroup() {
        return group;
    }

    public void publish(Tweet tweet) {
        newsFeed.notifyUsers(tweet);
    }

    public void display() {
        for(Tweet t : tweets) {
            System.out.println(t.getAuthor().getName() + " : " + t.getTweet());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}