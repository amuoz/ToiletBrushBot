package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.Commands;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Commander {

	public static final Commander COMMANDER = new Commander();

	public static Commander getInstance() {
		return COMMANDER;
	}

	private Commander() {
	}

	public void execute(String userInput) {

		// input example: use letrina
		String[] input = userInput.split(" ");
		String command = input[0].toLowerCase();

		Item item = null;

		if (!isValidCommand(command)) {
			// command does not exist
			log.info("No existe el comando");
			ToiletBrushHandler.getInstance().sendMessageToUser(Messages.commandNotExist);
			return;
		}

		// If action command then get item
		if (!command.equals(Commands.startCmd) && !command.equals(Commands.helpCmd)) {
			// check user wrote item name
			if (input.length < 2) {
				log.info("Usuario no especifica item");
				ToiletBrushHandler.getInstance().sendMessageToUser(Messages.noItem);
				return;
			}

			String itemName = input[1].toLowerCase();

			// check if item exist
			item = Game.getInstance().getItem(itemName);
			if (item == null) {
				log.info("No existe el item");
				ToiletBrushHandler.getInstance().sendMessageToUser(Messages.itemNotExist);
				return;
			}
		}

		switch (command) {
		case Commands.startCmd:
			ToiletBrushHandler.getInstance().sendMessageToUser(Messages.start);
			break;
		case Commands.helpCmd:
			ToiletBrushHandler.getInstance().sendMessageToUser(Messages.help);
			break;
		case Commands.examineCmd:
			item.examine();
			break;
		case Commands.useCmd:
			item.use();
			break;
		case Commands.pickCmd:
			item.pick();
			break;
		case Commands.talkCmd:
			item.talk();
			break;
		}

	}

	private boolean isValidCommand(String command) {
		return command.equals(Commands.startCmd) || command.equals(Commands.helpCmd) || command.equals(Commands.useCmd)
				|| command.equals(Commands.examineCmd) || command.equals(Commands.pickCmd)
				|| command.equals(Commands.talkCmd);
	}

}
