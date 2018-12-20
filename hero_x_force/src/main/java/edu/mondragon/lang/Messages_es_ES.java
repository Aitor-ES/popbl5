package edu.mondragon.lang;

import java.util.ListResourceBundle;

public class Messages_es_ES  extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"user.login.success", "¡Ya has iniciado la sesión!"},
			{"user.logout.success", "¡Ya has cerrado la sesión!"},
			{"user.new.success", "¡El usuario ha sido registrado!"},
			{"user.edit.success", "¡El usuario ha sido modificado!"},
			{"user.delete.success", "¡El usuario ha sido borrado!"},
	};
}
