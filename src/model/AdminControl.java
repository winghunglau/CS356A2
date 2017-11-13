package model;

import java.util.HashMap;

/**
 * This is the AdminControl class.
 * It uses the singleton pattern which only allows to have an instance.
 * It is used to create users and user groups.
 */
public class AdminControl {
    private static int id;
    private static AdminControl instance = null;
    private static UserGroup root;
    private static HashMap<String, Component> nameMap;
    private static HashMap<Integer, Component> idMap;

    private AdminControl(){};

    public static AdminControl getInstance() {
        if(instance == null) {
            instance = new AdminControl();
            id = 0;
            root = new UserGroup(id, "Root");
            nameMap = new HashMap<String, Component>();
            idMap = new HashMap<Integer, Component>();
            nameMap.put("Root", root);
            idMap.put(0, root);
            CountVisitor.getInstance().visitUserGroup();
        }
        return instance;
    }

    public UserGroup getRoot() {
        return root;
    }

    public User createUser(String name) {
        id++;
        User newUser = new User(id, name);
        if (nameMap.containsKey(name)) {
            return (User) nameMap.get(name);
        }
        nameMap.put(name, newUser);
        idMap.put(id, newUser);
        return newUser;
    }
    
    public Component getComponentByName(String name) {
        return nameMap.get(name);
    }

    public Component getComponentByID(int id) {
        return idMap.get(id);
    }

    public UserGroup createUserGroup(String name) {
        id++;
        UserGroup newUserGroup = new UserGroup(id, name);
        if (nameMap.containsKey(name)) {
            return (UserGroup) nameMap.get(name);
        }
        nameMap.put(name, newUserGroup);
        idMap.put(id, newUserGroup);
        return newUserGroup;
    }
    
    public int showUserTotal() {
        return CountVisitor.getInstance().getUserCount();
    }

    public int showGroupTotal() {
        return CountVisitor.getInstance().getGroupCount();
    }

    public int showTweetTotal() {
        return CountVisitor.getInstance().getTweetCount();
    }

    public int showPosTweetTotal() {
        return CountVisitor.getInstance().getPosTweetCount();
    }

}