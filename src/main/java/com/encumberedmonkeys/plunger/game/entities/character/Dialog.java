package com.encumberedmonkeys.plunger.game.entities.character;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Dialog {

	private String greeting;
	private String name;
	protected Map<String, Conversation> conversations;

	public Dialog(String name) {
		this.greeting = "...";
		this.name = name;
		this.conversations = new HashMap<String, Conversation>();
	}

}
