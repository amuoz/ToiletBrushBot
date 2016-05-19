package com.encumberedmonkeys.plunger.game.entities.items;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;

public class Gancho extends Item {

	public Gancho(Game game) {
		super(game);
		this.catchable = false;
		this.enInventario = true;
	}

	@Override
	public String getName() {
		return getMsg("gancho.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("gancho.examine"));
	}

	@Override
	public void use() {
	}

	@Override
	public void use(Entity entity) {
		if (entity.getName().equals(getMsg("manivela.name"))) {
			// me desatasco
			game.getPlayer().setAtascado(false);

			// mantenemos gancho en el inventario
	
			// manivela no desaparece pero marcamos como rota
			Manivela manivela = (Manivela) entity;
			manivela.setRota(true);
			
			sendMessageToUser(getMsg("plunger.desatascado"));
		} else {
			sendMessageToUser(getMsg("item.noMsg"));
		}
	}

}
