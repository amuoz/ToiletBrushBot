
package com.encumberedmonkeys.plunger;

import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

/**
 * @author muoz & thenanox
 * @version 0.1
 * Clase principal registrar el bot.
 */
@Slf4j
public class Main {

	public static void main(String[] args) {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(ToiletBrushHandler.getInstance());
		} catch (TelegramApiException e) {
			log.error("Error in Telegram bot", e);
		}
	}

}
