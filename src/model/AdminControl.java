package model;

/**
 * This is the AdminControl class.
 * It uses the singleton pattern which only allows to have an instance.
 * It is used to create users and user groups.
 */
public class AdminControl {
    private static int id;
    private static AdminControl instance = null;
    private static UserGroup root;

    private AdminControl(){};

    public static AdminControl getInstance() {
        if(instance == null) {
            instance = new AdminControl();
            id = 0;
            root = new UserGroup(id, "Root");
        }
        return instance;
    }

    public UserGroup getRoot() {
        return root;
    }

    public User createUser(String name) {
        id++;
        User newUser = new User(id, name);
        CountVisitor.getInstance().visitUser();
        return newUser;
    }

    public UserGroup createUserGroup(String name) {
        id++;
        UserGroup newUserGroup = new UserGroup(id, name);
        CountVisitor.getInstance().visitUserGroup();
        return newUserGroup;
    }

    public void addComponent(Component c) {
        root.add(c);
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