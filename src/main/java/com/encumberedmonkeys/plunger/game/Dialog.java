package com.encumberedmonkeys.plunger.game;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Dialog {

	private String pregunta;
	private String respuesta;

	private List<Dialog> conversaciones;

	private boolean activo;
	private boolean desactivable;
	private boolean cerrar;

	public Dialog() {
		conversaciones = new ArrayList<Dialog>();
		desactivable = true;
	}

	public void desactivar() {
		if (desactivable) {
			setActivo(false);
		}
	}

}
