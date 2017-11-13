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
public class User implements TreeModel, Component, Observer{
	
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
    public Object getRoot() {
        System.out.println("getRoot");
        return AdminControl.getInstance().getRoot();
    }

    @Override
    public Object getChild(Object parent, int index) {
        System.out.println("getChild");
        if(parent instanceof UserGroup) {
            List<Component> group = ((UserGroup) parent).getComponents();
            return group.get(index);
        }
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        System.out.println("getChildCount");
        if(parent instanceof UserGroup) {
            List<Component> group = ((UserGroup) parent).getComponents();
            return group.size();
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        System.out.println("isLeaf");
        if(node instanceof UserGroup) {
            return false;
        }
        return true;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        System.out.println("valueForPathChanged");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        System.out.println("getIndexOfChild");
        if(parent instanceof UserGroup) {
            List<Component> components = ((UserGroup) parent).getComponents();
            return components.indexOf(child);
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        System.out.println("addTreeModelListener");
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        System.out.println("removeTreeModelListener");
    }
    
    @Override
    public String toString() {
        return name;
    }
}