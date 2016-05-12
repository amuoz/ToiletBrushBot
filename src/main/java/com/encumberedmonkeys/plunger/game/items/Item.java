package com.encumberedmonkeys.plunger.game.items;

import lombok.Data;

@Data
public abstract class Item {
	protected String name; // identificador único del objeto

	protected String examineMsg;
	protected String useMsg;
	protected String pickMsg;

	public abstract void examine();

	public abstract void use();

	public abstract void pick();

	public abstract void talk();

}
