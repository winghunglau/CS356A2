package model;

import java.util.*;

/**
 * This is the Component interface for the User and UserGroup classes.
 * It uses the composite pattern.
 */
public interface Component {
		
    public String getName();
    public int getID();
    public List<Component> getComponents();

    public void add(Component c);
	
}