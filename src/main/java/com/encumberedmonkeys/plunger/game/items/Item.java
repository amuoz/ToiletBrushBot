package com.encumberedmonkeys.plunger.game.items;

import java.util.List;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.services.LocationService;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

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

	public abstract void use();

	public abstract void use(Item item);

	public abstract void talk();

	public void pick() {
		// si el objeto es cogible
		if (catchable) {
			if (!enInventario) {
				// insertar en el invetario
				enInventario = true;
				game.getPlayer().getInventory().add(this);
				// quitar del level
				game.getLevel().getObjects().remove(this);

				sendMessageToUser(getPickMsg());
			} else {
				sendMessageToUser(getNoPickInventoryMsg());
			}
		} else {
			sendMessageToUser(getImpossibleMsg());
		}
	}

	// Generic messages
	private String getPickMsg() {
		return LocationService.getInstance().getString("item.pickMsg");
	}

	private String getImpossibleMsg() {
		return LocationService.getInstance().getString("item.impossibleMsg");
	}

	private String getNoPickInventoryMsg() {
		return LocationService.getInstance().getString("item.noPickInventoryMsg");
	}

	// Utils
	public String getMsg(String msg) {
		return LocationService.getInstance().getString(msg);
	}

	public void sendMessageToUser(String text) {
		ToiletBrushHandler.getInstance().sendMessageToUser(text);
	}

	public void sendPhotoToUser(String photoId) {
		ToiletBrushHandler.getInstance().sendPhotoToUser(photoId);
	}

	public void sendKeyboardMessageToUser(String text, List<KeyboardRow> replies) {
		ToiletBrushHandler.getInstance().sendKeyboardMessageToUser(text, replies);
	}

}
