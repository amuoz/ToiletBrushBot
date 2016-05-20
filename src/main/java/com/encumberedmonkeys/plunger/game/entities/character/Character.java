package com.encumberedmonkeys.plunger.game.entities.character;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;

public abstract class Character extends Entity {

	private final String INIT = "@S";
	private final String OPTION = "@";
	private final String RETURN = "return";
	private final String OPTION_ON = "option-on";
	private final String OPTION_OFF = "option-off";
	private final String STOP = "stop";
	private final String OFF = "off";
	private final String GOTO = "go-to";
	private final String PAD = "#";

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

		for (String option : conversation.getOptionOff()) {
			dialog.getConversations().get(option).setActive(false);
		}
		for (String option : conversation.getOptionOn()) {
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

	public Dialog dialogMapper(String fileName) {

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		Dialog dialog = null;

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.startsWith(INIT)) { // @S
					
					dialog = new Dialog(file.getName().substring(0, file.getName().length()-3)); // dPelo1

					line = scanner.nextLine();
					StringBuilder greeting = new StringBuilder("");
					while (!line.equals(RETURN)) {
						greeting.append(line);
						line = scanner.nextLine();
					}
					
					// no machacar el por defecto
					if(greeting.length()>0){
						dialog.setGreeting(greeting.toString());
					}
					
				} else if (line.startsWith(OPTION)) {

					String[] option = line.split(PAD); // @1#off#question
					String conversationId = option[0].substring(1, option[0].length());
					Conversation conversation = new Conversation(conversationId);
					dialog.getConversations().put(conversation.getId(), conversation);

					if (option[1].equals(OFF)) {
						conversation.setActive(false);
						conversation.setOption(option[2]);
					} else {
						conversation.setOption(option[1]);
					}

					line = scanner.nextLine();
					String answer = "";
					while (!line.startsWith(RETURN) && !line.startsWith(GOTO) && !line.startsWith(STOP)) {
						// option-on 2 3 4
						if (line.startsWith(OPTION_ON)) {
							String[] options = line.split(" ");
							for (int i = 1; i < options.length; i++) {
								conversation.getOptionOn().add(options[i]);
							}
							// option-off 1
						} else if (line.startsWith(OPTION_OFF)) {
							String[] options = line.split(" ");
							for (int i = 1; i < options.length; i++) {
								conversation.getOptionOff().add(options[i]);
							}
						} else {
							answer += line+"\n";
						}
						line = scanner.nextLine();
					}
					conversation.setAnswer(answer);

					// dialogo de retorno
					if (line.startsWith(RETURN)) {
						conversation.setDialog(dialog.getName()); // self
					} else if (line.startsWith(STOP)) {
						conversation.setDialog(dialog.getName()); // self
						conversation.setStop(true);
					} else if (line.startsWith(GOTO)) {
						String[] next = line.split(" "); // go-to dPelo2
						conversation.setDialog(next[1]);
					} else {
						throw new IOException("Mapping dialog error: " + line);
					}

				} else {
					throw new IOException("Mapping dialog error: " + line);
				}
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return dialog;
	}

}
