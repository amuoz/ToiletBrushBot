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

	public String execute(String userInput) {

		// input example: use letrina
		String[] input = userInput.split(" ");
		String command = input[0].toLowerCase();

		log.debug("userInput: " + userInput);

		Item item = null;

		if (!isValidCommand(command)) {
			// command does not exist
			log.info("No existe el comando");
			return Messages.commandDoesntExist;
		}

		// If action command then get item
		if (!command.equals(Commands.startCmd) && !command.equals(Commands.helpCmd)) {
			// check user wrote item name
			if (input.length < 2) {
				log.info("Usuario no especifica item");
				return Messages.noItem;
			}

			String itemName = input[1].toLowerCase();

			// check if item exist
			item = Game.getInstance().getItem(itemName);
			if (item == null) {
				log.info("No existe el item");
				return Messages.itemNotExist;
			}
		}

		switch (command) {
			case Commands.startCmd:
				return Messages.start;
			case Commands.helpCmd:
				return Messages.help;
			case Commands.examineCmd:
				return item.examine();
			case Commands.useCmd:
				return item.use();
			case Commands.pickupCmd:
				return item.pick();
			case Commands.talkCmd:
				return item.talk();
			case Commands.inventoryCmd:
				String result = "";
				for(Item itemInInventory : Game.getInstance().getAllItems()){
					result += itemInInventory.getName() + "\n";
				}
				return result;
			default:
				return "";
		}
	}

	private boolean isValidCommand(String command) {
		return command.equals(Commands.startCmd) || command.equals(Commands.helpCmd) || command.equals(Commands.useCmd)
				|| command.equals(Commands.examineCmd) || command.equals(Commands.pickupCmd) || command.equals(Commands.inventoryCmd)
				|| command.equals(Commands.talkCmd);
	}

}
