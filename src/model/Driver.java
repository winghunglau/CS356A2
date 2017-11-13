package model;

/**
*This is the Driver class.
* It includes the main method for testing the logic part.
*/
class Driver {
	
    public static void main(String[] args) {
        AdminControl admin = AdminControl.getInstance();
        User john = admin.createUser("John");
        User bob = admin.createUser("Bob");
        User steve = admin.createUser("Steve");
        User stu1 = admin.createUser("Stu1");
        UserGroup cs356 = admin.createUserGroup("CS356");
        UserGroup cs356s1 = admin.createUserGroup("CS356s1");
//        admin.addComponent(john);
//        admin.addComponent(bob);
//        admin.addComponent(steve);
//        admin.addComponent(cs356);
//        admin.addComponent(cs356s1);
        cs356.add(john);
        cs356.add(stu1);
        john.addFollower(bob);
        john.addFollower(steve);
        john.publish(new Tweet("First Tweet", john));
        System.out.print("John's window: ");
        john.display();
        System.out.print("Bob's window: ");
        bob.display();
        System.out.print("Steve's window: ");
        steve.display();
        System.out.println("Total User: " + admin.showUserTotal());
        System.out.println("Total User Group: " + admin.showGroupTotal());
        System.out.println("Total Tweet: " + admin.showTweetTotal());
        System.out.println("Total Positive Tweet: " + admin.showPosTweetTotal());

    }
}