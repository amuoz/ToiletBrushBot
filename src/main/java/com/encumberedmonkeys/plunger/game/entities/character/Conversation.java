package com.encumberedmonkeys.plunger.game.entities.character;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Conversation {

	private String id;
	private String option;
	private String answer;

	// return dialog name
	private String dialog;

	// lista de conversaciones desactivar
	private List<String> optionOff;
	// lista de conversaciones activar
	private List<String> optionOn;

	// dialogo se muestra o no al usuario
	private boolean active;
	// dialogo cierra conversación
	private boolean stop;

	public Conversation(String id) {
		this.id = id;
		active = true;
		stop = false;
		optionOff = new ArrayList<String>();
		optionOn = new ArrayList<String>();
	}

}
