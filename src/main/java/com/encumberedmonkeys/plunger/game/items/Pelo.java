package com.encumberedmonkeys.plunger.game.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import com.encumberedmonkeys.plunger.game.Conversation;
import com.encumberedmonkeys.plunger.game.Dialog;
import com.encumberedmonkeys.plunger.game.Game;

public class Pelo extends Item {

	private final String start = "dPelo1";
	private String actual = "";
	private Map<String, Dialog> dialogs;

	public Pelo(Game game) {
		super(game);
		
		Dialog d1 = new Dialog("dPelo1");
		
		Conversation c1 = new Conversation();
		c1.setOption("¿Quién eres?");
		c1.setAnswer("_Pelo_: Soy tu primer *pelo* pubertoso, soy tu pelo de adolescencia.");
		c1.setDialog(d1.getName());
		
		Conversation c2 = new Conversation();
		c2.setOption("¿Puedo arrancarte de mi mejilla?");
		c2.setAnswer("_Pelo_: Vale, pero primero te arranco yo las piernas.\n_Plunger_: Eso no suena demasiado bien...mejor lo dejamos estar.");
		c2.setDialog(d1.getName());
		
		Conversation c3 = new Conversation();
		c3.setOption("Adios Pubert.");
		c3.setAnswer("_Pubert_: Me encantó solo en casa, el momento del afeitado fué genial. ¡Adiós!");
		c3.setDialog(d1.getName());
		c3.setStop(true);
		
		d1.getConversations().add(c1);
		d1.getConversations().add(c2);
		d1.getConversations().add(c3);
		
		dialogs = new HashMap<String, Dialog>();
		dialogs.put(d1.getName(), d1);
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
		Dialog dialog = dialogs.get(start);
		actual = start;
		List<List<InlineKeyboardButton>> keyboard = opcionesKeyboard(dialog);
		sendInlineKeyboardMessageToUser(dialog.getGreeting(), keyboard);
	}

	@Override
	public void talk(Integer conversationId) {

		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		Dialog dialog = dialogs.get(actual);
		Conversation conversation = dialog.getConversations().get(conversationId);
		
		// actualizar opciones de teclado si no es cierre
		if (!conversation.isStop()) {
			actual = conversation.getDialog();
			keyboard = opcionesKeyboard(dialogs.get(actual));
		}
				
		editMessageTextToUser(conversation.getAnswer(), keyboard);
	}

	/**
	 * 
	 * @return Lista de opciones activas
	 */
	private List<List<InlineKeyboardButton>> opcionesKeyboard(Dialog dialog) {
		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		for (int i = 0; i < dialog.getConversations().size(); i++) {
			Conversation conversation = dialog.getConversations().get(i);
			// solo incluimos conversaciones activas
			if (conversation.isActive()) {
				List<InlineKeyboardButton> inlineKeyboard = new ArrayList<InlineKeyboardButton>();
				InlineKeyboardButton inline = new InlineKeyboardButton();
				inline.setText(conversation.getOption());
				inline.setCallbackData(getName() + " " + String.valueOf(i));
				inlineKeyboard.add(inline);
				keyboard.add(inlineKeyboard);
			}
		}
		return keyboard;
	}

}
