package homeshopping.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface homeShoppingCommand {
	
	public abstract void execute(HttpServletRequest request, HttpServletResponse response);
	
}
