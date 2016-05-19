package com.encumberedmonkeys.plunger.game.entities.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Foto extends Item {

	private boolean examinada;

	public Foto(Game game) {
		super(game);
		this.catchable = false;
		this.enInventario = true;
		this.examinada = false;
	}

	@Override
	public String getName() {
		return getMsg("foto.name");
	}

	@Override
	public void examine() {
		if (!examinada) {
			examinada = true;
			game.getPlayer().getInventory().add(new Chicle(game));
			sendMessageToUser(getMsg("foto.examine1"));
			sendPhotoToUser(getMsg("img.feo"));
		} else {
			sendMessageToUser(getMsg("foto.examine2"));
			sendPhotoToUser(getMsg("img.feo"));
		}
	}

}
