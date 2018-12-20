package edu.mondragon.lang;

import java.util.ListResourceBundle;

public class View_es_ES extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			// Actions
			{"action.save", "Guardar"},
			{"action.edit", "Editar"},
			{"action.delete", "Borrar"},
			{"action.login", "Iniciar sesión"},
			{"action.logout", "Cerrar sesión"},
			{"action.register", "Registrarse"},
			{"action.new", "Nuevo"},
			{"action.back", "Atrás"},
			{"action.confirm", "Confirmar"},
				
			// Header resources
			{"header.appName", "Hero X-Force"},
			{"header.lang", "Idioma"},
			{"header.home", "Inicio"},
			{"header.profile", "Perfil"},
			{"header.decks", "Mazos"},
			{"header.heroes", "Héroes"},
			{"header.duels", "Duelos"},
			{"header.tournaments", "Torneos"},
			{"header.ranking", "Rankings"},
			
			// Languages
			{"language.en", "Inglés"},
			{"language.es", "Español"},
			{"language.eu", "Vasco"},

			// Home
			{"home.text1","Text1"},
			
			// User Form
			{"userForm.title.create","Crear Perfil"},
			{"userForm.title.edit","Editar Perfil"},
			{"userForm.nickname","Nombre de usuario"},
			{"userForm.password","Contraseña"},
			{"userForm.email","Email"},
			
			// Profile
			{"profile.title","Perfil"},
			
			// Others
			{"general.text1","Text1"},
	};

}
