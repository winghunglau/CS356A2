package model;

import java.util.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * This is the UserGroup class.
 * It includes all the information and actions of a user group.
 */
public class UserGroup implements Component{
	
    private int groupID;
    private String groupName;
    private List<Component> components;

    public UserGroup(int id, String name) {
        groupID = id;
        groupName = name;
        components = new ArrayList<Component>();
    }
    
    @Override 
    public String getName() {
        return groupName;
    }

    @Override
    public int getID() {
        return groupID;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public void add(Component c) {
        if(c instanceof User) {
            User user = (User)c;
            if(user.getGroup() == null) {
                components.add(user);
                user.setGroup(this);
            }
            else {
                System.out.println("A user can only be included in 1 group.");
            }
        }
        else {
            components.add(c);
        }
    }
    
    @Override
    public String toString() {
        return groupName;
    }
}