package com.encumberedmonkeys.plunger.commander;

import com.encumberedmonkeys.plunger.commander.actions.*;
import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.Messages;
import com.encumberedmonkeys.plunger.game.entities.Entity;
import com.encumberedmonkeys.plunger.services.LocationService;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Commander {

	private static final Commander COMMANDER = new Commander();
	private static final Map<Integer, Game> games = new HashMap<>();

	private static final String use = LocationService.getInstance().getString("command.use");
	private static final String pick = LocationService.getInstance().getString("command.pick");
	private static final String examine = LocationService.getInstance().getString("command.examine");
	private static final String talk = LocationService.getInstance().getString("command.talk");
	private static final String inventory = LocationService.getInstance().getString("command.inventory");
	private static final String shit = LocationService.getInstance().getString("command.shit");

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

	private void newGame(Integer gameId) {
		Game game = new Game();
		games.put(gameId, game);
	}

	public void execute(Message message) {
		log.debug("userInput: " + message.getText());

		String[] input = message.getText().toLowerCase().split(" ");
		switch (input[0].toLowerCase()) {
		case Commands.startCmd:
			newGame(message.getFrom().getId());
			sendMessageToUser(Messages.start());
			sendPhotoToUser(LocationService.getInstance().getString("img.letrina"));
			break;
		case Commands.helpCmd:
			sendMessageToUser(Messages.help());
			break;
		case Commands.languageCmd:
			if (input.length == 2) {
				setLanguage(input[1]);
				sendMessageToUser(Messages.language());
			} else {
				sendMessageToUser("¿A que idioma quieres cambiarlo?");
			}
			break;
		default:
			Game game = obtainGame(message.getFrom().getId());
			Action action = createAction(game, input);
			if (action != null)
				ActionHandler.getInstance().handle(action);
			break;
		}
	}

	private Action createAction(Game game, String[] input) {
		Action action = null;
		String comando = input[0].toLowerCase();

		if (comando.equals(Commander.examine)) {
			if (input.length == 2) {
				Entity first = game.getEntity(input[1]);
				if (first != null) {
					action = new Examine(game, first);
				} else {
					sendMessageToUser(Messages.itemNotExist());
				}
			} else if (input.length == 1) {
				sendMessageToUser(Messages.noItem());
			} else {
				sendMessageToUser(Messages.tooMuchItems());
			}
		} else if (comando.equals(Commander.pick)) {
			if (input.length == 2) {
				Entity first = game.getEntity(input[1]);
				if (first != null) {
					action = new Pick(game, first);
				} else {
					sendMessageToUser(Messages.itemNotExist());
				}
			} else if (input.length == 1) {
				sendMessageToUser(Messages.noItem());
			} else {
				sendMessageToUser(Messages.tooMuchItems());
			}
		} else if (comando.equals(Commander.use)) {
			if (input.length == 2) {
				Entity first = game.getEntity(input[1]);
				if (first != null) {
					action = new Use(game, first);
				} else {
					sendMessageToUser(Messages.itemNotExist());
				}
			} else if (input.length == 3) {
				Entity first = game.getEntity(input[1]);
				Entity second = game.getEntity(input[2]);
				if (first != null && second != null) {
					action = new UseWith(game, first, second);
				} else if (first == null) {
					sendMessageToUser(Messages.itemNotExist());
				} else if (second == null) {
					sendMessageToUser(Messages.secondItemNotExist());
				}
			} else if (input.length == 1) {
				sendMessageToUser(Messages.noItem());
			} else {
				sendMessageToUser(Messages.tooMuchItems());
			}
		} else if (comando.equals(Commander.talk)) {
			if (input.length == 2) {
				Entity first = game.getEntity(input[1]);
				if (first != null) {
					action = new Talk(game, first);
				} else {
					sendMessageToUser(Messages.itemNotExist());
				}
			} else if (input.length == 1) {
				sendMessageToUser(Messages.noItem());
			} else {
				sendMessageToUser(Messages.tooMuchItems());
			}
		} else if (comando.equals(Commander.inventory)) {
			if (input.length == 1) {
				action = new Inventory(game);
			} else {
				sendMessageToUser(Messages.tooMuchItems());
			}
		} else if (comando.equals(Commander.shit)) {
			if (input.length == 1) {
				action = new Shit(game);
			}
		} else {
			log.info("El comando no existe: ", input[0]);
			sendMessageToUser(Messages.commandDoesntExist());
		}

		return action;
	}

	public void executeCallback(CallbackQuery callbackQuery) {
		log.debug("callbackQuery data: " + callbackQuery.getData());

		String[] input = callbackQuery.getData().toLowerCase().split(" ");

		Game game = obtainGame(callbackQuery.getFrom().getId());
		Entity first = game.getEntity(input[0]);
		Integer dialogo = Integer.parseInt(input[1]);

		Action action = new Speaking(game, first, dialogo);
		ActionHandler.getInstance().handle(action);
	}

	private void setLanguage(String language) {
		LocationService locationService = LocationService.getInstance();
		if (locationService.getSupportedLanguages().containsKey(language)) {
			locationService.setLanguage(language);
		}
		sendMessageToUser("Se ha cambiado el idioma a: " + language);
	}

	private void sendMessageToUser(String text) {
		ToiletBrushHandler.getInstance().sendMessageToUser(text);
	}

	private void sendPhotoToUser(String photoId) {
		ToiletBrushHandler.getInstance().sendPhotoToUser(photoId);
	}

}
