import java.util.*;

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
				System.out.println("The same user can only be included in one group.");
			}
		}
		else {
			components.add(c);
		}
	}

	
}