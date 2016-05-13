package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

public abstract class Item {

	public abstract String getName();

	public abstract String examine();

	public abstract void use();

	public abstract String pick();

	public abstract String talk();

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
