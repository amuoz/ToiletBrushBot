package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Game;

public class Escobilla extends Item {

	public Escobilla(Game game) {
		super(game);
		this.catchable = true;
	}

	@Override
	public String getName() {
		return getMsg("escobilla.name");
	}

	@Override
	public String examine() {
		return getMsg("escobilla.examine");
	}

	@Override
	public void use() {
		sendMessageToUser(getMsg("escobilla.use"));
	}

	@Override
	public void use(Item item) {

		// desaparece escobilla del inventario o escena
		if (enInventario) {
			game.getPlayer().getInventory().remove(this);
		} else {
			game.getLevel().getObjects().remove(this);
		}

		// desaparece cordoneras del inventario o escena
		if (item.enInventario) {
			game.getPlayer().getInventory().remove(item);
		} else {
			game.getLevel().getObjects().remove(item);
		}

		// se crea un gancho
		game.getPlayer().getInventory().add(new Gancho(game));

		sendMessageToUser(getMsg("gancho.new"));
	}

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return null;
	}

}
