package com.encumberedmonkeys.plunger.game.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.encumberedmonkeys.plunger.game.Dialog;
import com.encumberedmonkeys.plunger.game.Game;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

public class Pelo extends Item {

	private List<Dialog> dialogs;

	public Pelo(Game game) {
		super(game);

		Dialog d1 = new Dialog();
		d1.setPregunta("_Plunger_: ¿Quién eres?");
		d1.setRespuesta("_Pelo_: Soy tu primer *pelo* pubertoso, soy tu pelo de adolescencia.");

		Dialog d11 = new Dialog();
		d11.setPregunta("_Plunger_: ¿Puedo arrancarte?");
		d11.setRespuesta(
				"_Pelo_: Vale, pero primero te arranco yo las piernas.\n_Plunger_: Eso no suena demasiado bien...mejor lo dejamos estar.");
		d1.getConversaciones().add(d11);

		Dialog d2 = new Dialog();
		d2.setPregunta("_Plunger_: Adios Pubert.");
		d2.setRespuesta("_Pubert_: Me encantó solo en casa, el momento del afeitado fué genial. ¡Adiós!");

		dialogs = new ArrayList<Dialog>();
		dialogs.add(d1);
		dialogs.add(d2);
	}

	@Override
	public String getName() {
		return getMsg("pelo.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("pelo.examine"));
	}

	@Override
	public void use() {
	}

	@Override
	public void use(Item item) {
	}

	@Override
	public void talk() {
		List<KeyboardRow> keyboard = new ArrayList<>();
		KeyboardRow keyrow = new KeyboardRow();
		for(Dialog dialog: dialogs) {
			keyrow.add(dialog.getPregunta());
		}
		keyboard.add(keyrow);
		sendKeyboardMessageToUser("test", keyboard);
	}
}
