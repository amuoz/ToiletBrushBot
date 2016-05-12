package com.encumberedmonkeys.plunger.game.items;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Item {

	ResourceBundle gameResources = ResourceBundle.getBundle("game.game", new Locale("es"));

	public abstract String getName();

	public abstract String examine();

	public abstract String use();

	public abstract String pick();

	public abstract String talk();

}
