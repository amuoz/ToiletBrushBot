package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

import lombok.Data;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@Data
public abstract class Item {
	ResourceBundle gameResources = ResourceBundle.getBundle("game.game", new Locale("es"));
	protected String nombre; // identificador único del objeto
	protected String examinar; // descripción mostrada al examinar el objeto
	protected String usarActivo; // descripción mostrada al usar el objeto
	protected String usarInactivo; // descripción mostrada al usar el objeto
	protected boolean coger; // indica si un objeto se puede coger o no
	protected boolean activo; // indica si un objeto está activo en escena
	protected boolean loTengo; // indica si un objeto está en el inventario

	public void examine() {
		ToiletBrushHandler.getInstance().sendMessageToUser(examinar);
	}

	public abstract void use() ;

	public abstract void pickup();

	public abstract void talk();

}
