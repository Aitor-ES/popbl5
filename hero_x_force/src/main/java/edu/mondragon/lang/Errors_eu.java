package edu.mondragon.lang;

import java.util.ListResourceBundle;

public class Errors_eu extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"general.notImplemented", "Oraindik ez da inplementatu."},
			{"general.notLogged", "Saioa hasi eragiketa hori egin nahi baduzu."},
			{"general.noPermission", "Ez duzu eragiketa hori egiteko baimenik."},
			
			{"user.load.fail","Arazoren bat egon da erabiltzailea jasotzerakoan."},
			{"user.new.fail", "Ezin izan da erabiltzaile berria sortu."},
			{"user.edit.fail", "Erabiltzaile hori ez da existitzen."},
			{"user.delete.fail", "Erabiltzaile hori ez da existitzen."},
			{"user.login.fail.noUser", "Erabiltzaile hori ez da existitzen."},
			{"user.login.fail.password", "Pasahitz okerra."},
	};

}
