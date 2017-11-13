package model;

/**
 * This is the ElementVisitor interface for the CountVisitor class.
 * It uses the visitor pattern.
 */
public interface ElementVisitor {
	
    public void visitUser();
    public void visitUserGroup();
    public void visitTweet();
    public void visitPositiveTweet();
	
}