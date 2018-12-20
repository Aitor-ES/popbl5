package edu.mondragon.lang;

import java.util.ListResourceBundle;

public class View_eu extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			// Actions
			{"action.save", "Gorde"},
			{"action.edit", "Editatu"},
			{"action.delete", "Ezabatu"},
			{"action.login", "Sesioa Hasi"},
			{"action.logout", "Sesioa Itxi"},
			{"action.register", "Erregistratu"},
			{"action.new", "Berria"},
			{"action.back", "Atzera"},
			{"action.confirm", "Baieztatu"},
				
			// Header resources
			{"header.appName", "Hero X-Force"},
			{"header.lang", "Hizkuntza"},
			{"header.home", "Sarrera"},
			{"header.profile", "Profila"},
			{"header.decks", "Pilloak"},
			{"header.heroes", "Heroiak"},
			{"header.duels", "Dueluak"},
			{"header.tournaments", "Leihaketak"},
			{"header.ranking", "Ranking"},
			
			// Languages
			{"language.en", "Ingelera"},
			{"language.es", "Espainiera"},
			{"language.eu", "Euskara"},
			
			// Home
			{"home.text1","Text1"},
			
			// User Form
			{"userForm.title.create","Profila Sortu"},
			{"userForm.title.edit","Profila Editatu"},
			{"userForm.nickname","Erabiltzaile izena"},
			{"userForm.password","Pasahitza"},
			{"userForm.email","Emaila"},
			
			// Profile
			{"profile.title","Profila"},
			
			// Others
			{"general.text1","Text1"},
	};

}
