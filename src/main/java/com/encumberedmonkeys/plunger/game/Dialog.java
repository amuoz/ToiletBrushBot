package com.encumberedmonkeys.plunger.game;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

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
