package com.encumberedmonkeys.plunger.game.items;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import com.encumberedmonkeys.plunger.game.Dialog;
import com.encumberedmonkeys.plunger.game.Game;

public class Pelo extends Item {

	private Dialog[] dialogs;

	public Pelo(Game game) {
		super(game);

		Dialog d1 = new Dialog();
		d1.setPregunta("¿Quién eres?");
		d1.setRespuesta("_Pelo_: Soy tu primer *pelo* pubertoso, soy tu pelo de adolescencia.");
		d1.setActivo(true);

		Dialog d11 = new Dialog();
		d11.setPregunta("¿Puedo arrancarte de mi mejilla?");
		d11.setRespuesta(
				"_Pelo_: Vale, pero primero te arranco yo las piernas.\n_Plunger_: Eso no suena demasiado bien...mejor lo dejamos estar.");
		d11.setActivo(false);
		d1.getConversaciones().add(d11);

		Dialog d2 = new Dialog();
		d2.setPregunta("Adios Pubert.");
		d2.setRespuesta("_Pubert_: Me encantó solo en casa, el momento del afeitado fué genial. ¡Adiós!");
		d2.setActivo(true);
		d2.setDesactivable(false);
		d2.setCerrar(true);

		dialogs = new Dialog[3];
		dialogs[0] = d1;
		dialogs[1] = d11;
		dialogs[2] = d2;
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

		for (int i = 0; i < dialogs.length; i++) {
			if (dialogs[i].isActivo()) {
				List<InlineKeyboardButton> inlineKeyboard = new ArrayList<InlineKeyboardButton>();
				InlineKeyboardButton inline = new InlineKeyboardButton();
				inline.setText(dialogs[i].getPregunta());
				inline.setCallbackData(getName() + " " + String.valueOf(i));
				inlineKeyboard.add(inline);
				keyboard.add(inlineKeyboard);
			}
		}

		sendInlineKeyboardMessageToUser("...", keyboard);
	}

	@Override
	public void talk(Integer dialogo) {

		for (Dialog dialog : dialogs[dialogo].getConversaciones()) {
			dialog.setActivo(true);
		}
		dialogs[dialogo].desactivar();

		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

		if (!dialogs[dialogo].isCerrar()) {
			for (int i = 0; i < dialogs.length; i++) {
				if (dialogs[i].isActivo()) {
					List<InlineKeyboardButton> inlineKeyboard = new ArrayList<InlineKeyboardButton>();
					InlineKeyboardButton inline = new InlineKeyboardButton();
					inline.setText(dialogs[i].getPregunta());
					inline.setCallbackData(getName() + " " + String.valueOf(i));
					inlineKeyboard.add(inline);
					keyboard.add(inlineKeyboard);
				}
			}
		}

		editMessageTextToUser(dialogs[dialogo].getRespuesta(), keyboard);

	}

}
