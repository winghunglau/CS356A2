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
public class UserGroup implements TreeModel, Component{
	
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
        return groupName;
    }
}