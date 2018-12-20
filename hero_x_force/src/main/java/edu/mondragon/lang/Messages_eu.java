package edu.mondragon.lang;

import java.util.ListResourceBundle;

public class Messages_eu  extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"user.login.success", "Saioa hasi duzu!"},
			{"user.logout.success", "Saioa itxi duzu!"},
			{"user.new.success", "Erabiltzailea erregistratu da!"},
			{"user.user.success", "Erabiltzailea eguneratu da!"},
			{"user.delete.success", "Erabiltzailea ezabatu da!"},
	};
}
