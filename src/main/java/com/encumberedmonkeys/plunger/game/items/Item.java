package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.services.LocalisationService;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

public abstract class Item {

	protected Game game;
	protected boolean enInventario;
	protected boolean catchable;

	public Item(Game game) {
		this.game = game;
		this.catchable = false;
		this.enInventario = false;
	}

	public abstract String getName();

	public abstract void examine();

	// Por defecto preguntamos usar con qué
	public void use() {
		sendMessageToUser(getMsg("item.useWithMsg"));
	}

	/**
	 * Usar con otro objeto (mergear)
	 * 
	 * @param item
	 */
	public abstract void use(Item item);

	public abstract String talk();

	public String pick() {
		// si el objeto es cogible
		if (catchable) {
			if (!enInventario) {
				// insertar en el invetario
				enInventario = true;
				game.getPlayer().getInventory().add(this);
				// quitar del level
				game.getLevel().getObjects().remove(this);

				return getPickMsg();
			}
			return getNoPickInventoryMsg();
		} else {
			return getImpossibleMsg();
		}

	}

	// Generic messages
	private String getPickMsg() {
		return LocalisationService.getInstance().getString("item.pickMsg");
	}

	private String getImpossibleMsg() {
		return LocalisationService.getInstance().getString("item.impossibleMsg");
	}

	private String getNoPickInventoryMsg() {
		return LocalisationService.getInstance().getString("item.noPickInventoryMsg");
	}

	// Utils
	public String getMsg(String msg) {
		return LocalisationService.getInstance().getString(msg);
	}

	public void sendMessageToUser(String text) {
		ToiletBrushHandler.getInstance().sendMessageToUser(text);
	}

	public void sendPhotoToUser(String photoId) {
		ToiletBrushHandler.getInstance().sendPhotoToUser(photoId);
	}

	public void sendKeyboardMessageToUser(String text) {
		ToiletBrushHandler.getInstance().sendKeyboardMessageToUser(text);
	}

}
