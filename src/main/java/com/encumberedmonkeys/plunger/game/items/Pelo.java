package com.encumberedmonkeys.plunger.game.items;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import com.encumberedmonkeys.plunger.game.Dialog;
import com.encumberedmonkeys.plunger.game.Game;

public class Pelo extends Item {

	private List<Dialog> dialogs;

	public Pelo(Game game) {
		super(game);

		Dialog d1 = new Dialog("¿Quién eres?", "_Pelo_: Soy tu primer *pelo* pubertoso, soy tu pelo de adolescencia.");
		Dialog d11 = new Dialog("¿Puedo arrancarte de mi mejilla?",
				"_Pelo_: Vale, pero primero te arranco yo las piernas.\n_Plunger_: Eso no suena demasiado bien...mejor lo dejamos estar.",
				false);
		d1.getConversaciones().add(d11);

		Dialog d2 = new Dialog("Adios Pubert.",
				"_Pubert_: Me encantó solo en casa, el momento del afeitado fué genial. ¡Adiós!");
		d2.setDesactivable(false);
		d2.setCerrar(true);

		dialogs = new ArrayList<Dialog>();
		dialogs.add(d1);
		dialogs.add(d11);
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
	public void talk() {
		// Inicio de conversación
		List<List<InlineKeyboardButton>> keyboard = opcionesKeyboard();
		sendInlineKeyboardMessageToUser("...", keyboard);
	}

	@Override
	public void talk(Integer dialogoId) {

		// quitar diálogo si es desactivable
		dialogs.get(dialogoId).desactivar();
		// activar subordinados
		for (Dialog dialog : dialogs.get(dialogoId).getConversaciones()) {
			dialog.setActivo(true);
		}

		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		// actualizar opciones de teclado si no es cierre
		if (!dialogs.get(dialogoId).isCerrar()) {
			keyboard = opcionesKeyboard();
		}

		editMessageTextToUser(dialogs.get(dialogoId).getRespuesta(), keyboard);
	}

	/**
	 * 
	 * @return Lista de opciones activas
	 */
	private List<List<InlineKeyboardButton>> opcionesKeyboard() {
		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		for (int i = 0; i < dialogs.size(); i++) {
			// solo incluimos conversaciones activas
			if (dialogs.get(i).isActivo()) {
				List<InlineKeyboardButton> inlineKeyboard = new ArrayList<InlineKeyboardButton>();
				InlineKeyboardButton inline = new InlineKeyboardButton();
				inline.setText(dialogs.get(i).getPregunta());
				inline.setCallbackData(getName() + " " + String.valueOf(i));
				inlineKeyboard.add(inline);
				keyboard.add(inlineKeyboard);
			}
		}
		return keyboard;
	}

}
