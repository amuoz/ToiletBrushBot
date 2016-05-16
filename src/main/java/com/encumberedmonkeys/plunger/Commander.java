package com.encumberedmonkeys.plunger;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Message;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.Messages;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.services.LocalisationService;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Commander {

	private static final Commander COMMANDER = new Commander();
	private static final Map<Integer, Game> games = new HashMap<>();

	public static Commander getInstance() {
		return COMMANDER;
	}

	private Commander() {
	}

	private Game obtainGame(Integer gameId) {
		Game game = games.get(gameId);
		if (game == null) {
			game = new Game();
			games.put(gameId, game);
		}
		return game;
	}

	public void execute(Message message) {
		Game game = obtainGame(message.getFrom().getId());
		String userInput = message.getText();
		// input example: use letrina
		String[] input = userInput.split(" ");
		String command = input[0].toLowerCase();
		String object = "";
		if (input.length > 1)
			object = input[1].toLowerCase();

		log.debug("userInput: " + userInput);

		Item item = null;
		Item item2 = null;

		if (!isValidCommand(command)) {
			// command does not exist
			log.info("No existe el comando");
			sendMessageToUser(Messages.commandDoesntExist());
		}

		if (command.equals(Commands.languageCmd)) {
			LocalisationService localisationService = LocalisationService.getInstance();
			if (localisationService.getSupportedLanguages().containsKey(object)) {
				localisationService.setLanguage(object);
			}
			sendMessageToUser("Se ha cambiado el idioma a: " + object);
		}

		// If action command then get item
		if (!command.equals(Commands.startCmd) && !command.equals(Commands.helpCmd)
				&& !command.equals(Commands.shitCmd)) {
			// check user wrote item name
			if (input.length < 2) {
				log.info("Usuario no especifica item");
				sendMessageToUser(Messages.noItem());
			}

			String itemName = object.toLowerCase();

			// check if item exist
			item = game.getItem(itemName);
			if (item == null) {
				log.info("No existe el item");
				sendMessageToUser(Messages.itemNotExist());
			}
		}

		// usar obj1 obj2
		if (command.equals(Commands.useCmd) && (input.length > 2)) {
			String item2Name = input[2].toLowerCase();
			// check if item exist
			item2 = game.getItem(item2Name);
			if (item2 == null) {
				log.info("No existe el segundo item");
				sendMessageToUser(Messages.secondItemNotExist());
			}
		}

		switch (command) {
		case Commands.startCmd:
			sendMessageToUser(Messages.start());
			break;
		case Commands.helpCmd:
			sendMessageToUser(Messages.help());
			sendPhotoToUser(LocalisationService.getInstance().getString("img.letrina"));
			break;
		case Commands.languageCmd:
			sendMessageToUser(Messages.language());
			break;
		case Commands.examineCmd:
			sendMessageToUser(item.examine());
			break;
		case Commands.useCmd:
			if (item2 == null) {
				item.use();
			} else {
				item.use(item2);
			}
			break;
		case Commands.pickupCmd:
			sendMessageToUser(item.pick());
			break;
		case Commands.talkCmd:
			sendMessageToUser(item.talk());
			break;
		case Commands.inventoryCmd:
			String result = "";
			for (Item itemInInventory : game.getAllItems()) {
				result += itemInInventory.getName() + "\n";
			}
			sendMessageToUser(result);
			break;
		case Commands.shitCmd:
			sendMessageToUser(LocalisationService.getInstance().getString("letrina.cagar"));
			sendMessageToUser(LocalisationService.getInstance().getString("plunger.atascado"));
			break;
		}

	}

	private boolean isValidCommand(String command) {
		return command.equals(Commands.startCmd) || command.equals(Commands.helpCmd) || command.equals(Commands.useCmd)
				|| command.equals(Commands.examineCmd) || command.equals(Commands.pickupCmd)
				|| command.equals(Commands.inventoryCmd) || command.equals(Commands.languageCmd)
				|| command.equals(Commands.talkCmd) || command.equals(Commands.shitCmd);
	}

	private void sendMessageToUser(String text) {
		ToiletBrushHandler.getInstance().sendMessageToUser(text);
	}

	private void sendPhotoToUser(String photoId) {
		ToiletBrushHandler.getInstance().sendPhotoToUser(photoId);
	}

}
