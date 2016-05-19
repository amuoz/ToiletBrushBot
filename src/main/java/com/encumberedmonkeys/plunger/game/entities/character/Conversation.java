package com.encumberedmonkeys.plunger.game.entities.character;

import lombok.Data;

@Data
public class Conversation {

	private String option;
	private String answer;

	// return dialog name
	private String dialog;

	// dialogo se muestra o no al usuario
	private boolean active;
	// dialogo cierra conversación
	private boolean stop;

	public Conversation() {
		active = true;
		stop = false;
	}

}
