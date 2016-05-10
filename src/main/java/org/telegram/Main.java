
package org.telegram;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.updateshandlers.ToiletBrushHandler;

/**
 * @author AMUNOZ
 * @version 1.0
 * @brief Clase principal registrar los bots.
 * @date 10-05-2016
 */
public class Main {
	private static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new ToiletBrushHandler());
		} catch (TelegramApiException e) {
			LOG.error(e);
		}
	}
}
