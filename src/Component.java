import java.util.*;

public interface Component {
		
	public String getName();
	public int getID();
	public List<Component> getComponents();
	
	public void add(Component c);
	
}