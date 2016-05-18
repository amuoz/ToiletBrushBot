package com.encumberedmonkeys.plunger.game;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Dialog {

	private String pregunta;
	private String respuesta;

	// conversaciones subordinadas
	private List<Dialog> conversaciones;

	// dialogo se muestra o no al usuario
	private boolean activo;
	
	// dialogo se puede desactivar
	private boolean desactivable;
	// dialogo cierra conversación
	private boolean cerrar;

	public Dialog(final String pregunta, final String respuesta, boolean activo) {
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		
		this.conversaciones = new ArrayList<Dialog>();

		this.desactivable = true;
		this.cerrar = false;
		this.activo = activo;
	}
	
	public Dialog(final String pregunta, final String respuesta) {
		this(pregunta, respuesta, true);
	}

	public void desactivar() {
		if (desactivable) {
			activo = false;
		}
	}

}
