package edu.mondragon.lang;

import java.util.ListResourceBundle;

/*
 * This is the default resource, in this case English.
 * If a resource is not found in other classes, or a non supported language is set,  
 * this class will be used.
 */
public class View extends ListResourceBundle {
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			// Actions
			{"action.save", "Save"},
			{"action.edit", "Edit"},
			{"action.delete", "Delete"},
			{"action.login", "Login"},
			{"action.logout", "Logout"},
			{"action.register", "Register"},
			{"action.new", "New"},
			{"action.back", "Back"},
			{"action.confirm", "Confirm"},
				
			// Header resources
			{"header.appName", "Hero X-Force"},
			{"header.lang", "Language"},
			{"header.home", "Home"},
			{"header.profile", "Profile"},
			{"header.decks", "Decks"},
			{"header.heroes", "Heroes"},
			{"header.duels", "Duels"},
			{"header.tournaments", "Tournaments"},
			{"header.ranking", "Ranking"},
			
			// Languages
			{"language.en", "English"},
			{"language.es", "Spanish"},
			{"language.eu", "Basque"},
			
			// Footer
			/* As this file is the default one and no translation is needed,
			 * the following 2 parameters are defined just in this file.
			 */
			{"footer.copyright", "2018 Copyright"},
			{"footer.company", "Hero X-Force"},
			
			// Home
			{"home.text1","Text1"},
			
			// User Form
			{"userForm.title.create","Create Profile"},
			{"userForm.title.edit","Edit Profile"},
			{"userForm.nickname","Nickname"},
			{"userForm.password","Password"},
			{"userForm.email","Email"},
			
			// Profile
			{"profile.title","Profile"},
			
			// Others
			{"general.text1","Text1"},
	};

}