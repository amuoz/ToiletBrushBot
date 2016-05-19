package com.encumberedmonkeys.plunger.game.entities.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;

public abstract class Character extends Entity {

	protected String start;
	protected String actual;
	protected Map<String, Dialog> dialogs;

	public Character(Game game) {
		this.game = game;
	}

	public void examine() {
		sendMessageToUser(getImpossibleMsg());
	}

	public void pick() {
		sendMessageToUser(getImpossibleMsg());
	}

	public void use() {
		sendMessageToUser(getImpossibleMsg());
	}

	public void use(Entity entity) {
		sendMessageToUser(getImpossibleMsg());
	}

	public void talk() {
		// Inicio de conversación
		Dialog dialog = dialogs.get(start);
		actual = start;
		List<List<InlineKeyboardButton>> keyboard = optionsKeyboard(dialog);
		sendInlineKeyboardMessageToUser(dialog.getGreeting(), keyboard);
	}

	public void talk(Integer dialogId) {
		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		Dialog dialog = dialogs.get(actual);
		Conversation conversation = dialog.getConversations().get(String.valueOf(dialogId));

		for(String option: conversation.getOptionOff()) {
			dialog.getConversations().get(option).setActive(false);
		}
		for(String option: conversation.getOptionOn()) {
			dialog.getConversations().get(option).setActive(true);
		}
		
		// actualizar opciones de teclado si no es cierre
		if (!conversation.isStop()) {
			actual = conversation.getDialog();
			keyboard = optionsKeyboard(dialogs.get(actual));
		}

		editMessageTextToUser(conversation.getAnswer(), keyboard);
	}

	protected List<List<InlineKeyboardButton>> optionsKeyboard(Dialog dialog) {
		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		for (int i = 1; i <= dialog.getConversations().size(); i++) {
			Conversation conversation = dialog.getConversations().get(String.valueOf(i));
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
