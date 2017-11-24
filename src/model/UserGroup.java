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
    private long createdTime;


    public UserGroup(int id, String name) {
        groupID = id;
        groupName = name;
        components = new ArrayList<Component>();
        createdTime = System.currentTimeMillis();
        System.out.println("Group Created : " + new Date(createdTime));
    }
    
    public long getCreatedTime() {
        return createdTime;
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
    public boolean add(Component c) {
        System.out.println("Adding");
        if(c instanceof User) {
            System.out.println("Adding User");
            User user = (User)c;
            if(user.getGroup() == null) {
                components.add(user);
                user.setGroup(this);
                CountVisitor.getInstance().visitUser();
                return true;
            }
            else {
                System.out.println("A user can only be included in 1 group.");
                return false;
            }
        } else {
            System.out.println("Adding Group");
            components.add(c);
            CountVisitor.getInstance().visitUserGroup();
            return true;
        }
    }
    
    @Override
    public String toString() {
        return groupName;
    }
}