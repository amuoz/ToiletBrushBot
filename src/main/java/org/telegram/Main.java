
package org.telegram;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.updateshandlers.MyProjectHandler;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Main class to create all bots
 * @date 20 of June of 2015
 */
public class Main {
	private static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new MyProjectHandler());
		} catch (TelegramApiException e) {
			LOG.error(e);
		}
	}
}
