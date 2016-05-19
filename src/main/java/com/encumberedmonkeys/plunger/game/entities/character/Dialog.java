package com.encumberedmonkeys.plunger.game.entities.character;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Dialog {

	private String greeting;
	private String name;
	List<Conversation> conversations;

	public Dialog(String name) {
		this.greeting = "...";
		this.name = name;
		this.conversations = new ArrayList<Conversation>();
	}

}
