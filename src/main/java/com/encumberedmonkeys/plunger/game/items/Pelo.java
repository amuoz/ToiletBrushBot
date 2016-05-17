package com.encumberedmonkeys.plunger.game.items;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import com.encumberedmonkeys.plunger.game.Dialog;
import com.encumberedmonkeys.plunger.game.Game;

public class Pelo extends Item {

	private List<Dialog> dialogs;

	public Pelo(Game game) {
		super(game);

		Dialog d1 = new Dialog();
		d1.setPregunta("Plunger: ¿Quién eres?");
		d1.setRespuesta("Pelo: Soy tu primer *pelo* pubertoso, soy tu pelo de adolescencia.");

		Dialog d11 = new Dialog();
		d11.setPregunta("Plunger: ¿Puedo arrancarte?");
		d11.setRespuesta(
				"Pelo: Vale, pero primero te arranco yo las piernas.\n_Plunger_: Eso no suena demasiado bien...mejor lo dejamos estar.");
		d1.getConversaciones().add(d11);

		Dialog d2 = new Dialog();
		d2.setPregunta("Plunger: Adios Pubert.");
		d2.setRespuesta("Pubert: Me encantó solo en casa, el momento del afeitado fué genial. ¡Adiós!");

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
		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		for (Dialog dialog : dialogs) {
			List<InlineKeyboardButton> inlineKeyboard = new ArrayList<InlineKeyboardButton>();
			InlineKeyboardButton inline = new InlineKeyboardButton(); 
			inline.setText(dialog.getPregunta());
			inline.setCallbackData("1 2 3 4 5");
			inlineKeyboard.add(inline);
			keyboard.add(inlineKeyboard);
		}
		sendInlineKeyboardMessageToUser("test", keyboard);
	}
	
	// normal keyboard version
	public void talk2() {
		List<KeyboardRow> keyboard = new ArrayList<>();
		for (Dialog dialog : dialogs) {
			KeyboardRow keyrow = new KeyboardRow();
			keyrow.add(dialog.getPregunta());
			keyboard.add(keyrow);
		}
		sendKeyboardMessageToUser("test", keyboard);
	}
	
}
