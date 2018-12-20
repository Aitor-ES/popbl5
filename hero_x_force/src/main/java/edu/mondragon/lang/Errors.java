package edu.mondragon.lang;

import java.util.ListResourceBundle;

/*
 * This is the default resource, in this case English
 * If a resource is not found in other classes,
 * or a non supported language is set, 
 * this class will be used.
 */
public class Errors  extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"general.notImplemented", "This is not implemented yet."},
			{"general.notLogged", "You must be logged to do this action."},
			{"general.noPermission", "You are not allowed to do this action."},
			
			{"user.load.fail","There has been a problem loading the user."},
			{"user.new.fail", "Unable to register new user."},
			{"user.edit.fail", "The user does not exist."},
			{"user.delete.fail", "The user does not exist."},
			{"user.login.fail.noUser", "The user does not exist."},
			{"user.login.fail.password", "Wrong password."},
	};
}
