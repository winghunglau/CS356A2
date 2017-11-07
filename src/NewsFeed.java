import java.util.*;

public class NewsFeed {
	
	private List<User> users;
	
	public NewsFeed() {
		users = new ArrayList<User>();	
	}
	
	public void attach(User user) {
		users.add(user);
	}
	
	public void notifyUsers(Tweet tweet) {
		for(User u: users) {
			u.update(tweet);
		}
	}
}
