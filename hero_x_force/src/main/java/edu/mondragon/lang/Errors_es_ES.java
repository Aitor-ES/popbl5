package edu.mondragon.lang;

import java.util.ListResourceBundle;

public class Errors_es_ES  extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"general.notImplemented", "Todavía no está implementado."},
			{"general.notLogged", "Tienes que tener la sesión iniciada para esta acción."},
			{"general.noPermission", "No tienes privilegios para esa acción."},
			
			{"user.load.fail","Ha habido un problema cargando el usuario."},
			{"user.new.fail", "No se ha podido registrar el nuevo usuario."},
			{"user.edit.fail", "Ese usuario no existe."},
			{"user.delete.fail", "Ese usuario no existe."},
			{"user.login.fail.noUser", "Ese usuario no existe."},
			{"user.login.fail.password", "Contraseña incorrecta."},
	};
}
