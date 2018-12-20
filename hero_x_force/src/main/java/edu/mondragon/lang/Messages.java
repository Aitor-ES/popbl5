package edu.mondragon.lang;

import java.util.ListResourceBundle;

public class Messages  extends ListResourceBundle {

/*
 * This is the default resource, in this case English
 * If a resource is not found in other classes,
 * or a non supported language is set, 
 * this class will be used.
 */
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"user.login.success", "You are now logged!"},
			{"user.logout.success", "You are now logged out!"},
			{"user.new.success", "The new user has been registered!"},
			{"user.edit.success", "The user has been modified!"},
			{"user.delete.success", "The user has been deleted!"},
	};
}
