package com.encumberedmonkeys.plunger.game;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Dialog {

	private String pregunta;
	private String respuesta;

	private List<Dialog> conversaciones;

	public Dialog() {
		conversaciones = new ArrayList<Dialog>();
	}

}
