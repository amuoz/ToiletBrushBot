package com.encumberedmonkeys.plunger.game.items;

import java.util.Random;

import com.encumberedmonkeys.plunger.game.Game;

public class Papel extends Item {

	private boolean enInventario;

	public Papel(Game game) {
		super(game);
		this.catchable = true;
		this.enInventario = false;
	}

	@Override
	public String getName() {
		return getMsg("papel.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("papel.examinePapelMsg"));
	}

	@Override
	public void use() {
		if (enInventario) {

			Letrina letrina = (Letrina) game.getItem(getMsg("letrina.name"));
			// si hemos cagado nos limpiamos
			if (letrina.isUsada()) {
				game.getPlayer().getInventory().remove(this);
				sendMessageToUser(getMsg("papel.usePapelCuloSucioMsg"));
			} else {
				sendMessageToUser(getMsg("papel.usePapelCuloLimpioMsg"));
			}

		} else {
			sendMessageToUser(getMsg("papel.usePapelNoInventarioMsg"));
		}
	}

	@Override
	public void talk() {
		getTalkMsg();
	}

	private void getTalkMsg() {
		int max = 6;
		int min = 1;
		Random rand = new Random();
		Integer result = rand.nextInt(max - min + 1) + min;
		switch (result) {
		case 1:
			sendMessageToUser(getMsg("papel.talk1Msg"));
		case 2:
			sendMessageToUser(getMsg("papel.talk2Msg"));
		case 3:
			sendMessageToUser(getMsg("papel.talk3Msg"));
		case 4:
			sendMessageToUser(getMsg("papel.talk4Msg"));
		case 5:
			sendMessageToUser(getMsg("papel.talk5Msg"));
		default:
			sendMessageToUser(getMsg("papel.talkNoMsg"));
		}
	}

	@Override
	public void use(Item item) {}

	@Override
	public void talk(Integer dialogo) {
		// TODO Auto-generated method stub
		
	}
}
