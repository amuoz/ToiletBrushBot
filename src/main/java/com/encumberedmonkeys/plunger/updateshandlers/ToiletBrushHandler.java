package com.encumberedmonkeys.plunger.updateshandlers;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import com.encumberedmonkeys.plunger.BotConfig;
import com.encumberedmonkeys.plunger.game.Commander;

import lombok.extern.slf4j.Slf4j;

/**
 * Manejador LongPolling para ToiletBrushBot.
 * 
 * @author AMUNOZ
 *
 */
@Slf4j
public class ToiletBrushHandler extends TelegramLongPollingBot {

	public static final ToiletBrushHandler HANDLER = new ToiletBrushHandler();

	public static ToiletBrushHandler getInstance() {
		return HANDLER;
	}

	// store current user chat id
	private String chatId;

	@Override
	public String getBotUsername() {
		return BotConfig.TOILET_BRUSH_USERNAME;
	}

	@Override
	public String getBotToken() {
		return BotConfig.TOILET_BRUSH_TOKEN;
	}

	@Override
	public void onUpdateReceived(Update update) {

		// user input handling
		Message message = update.getMessage();

		if (message != null && message.hasText()) {
			// load user id
			chatId = message.getChatId().toString();
			// launch command
			Commander.getInstance().execute(message.getText());
		}

	}

	/**
	 * Send text message to current user
	 * 
	 * @param text
	 */
	public void sendMessageToUser(String text) {
		sendMessageToUser(chatId, text);
	}

	/**
	 * Send text message to specified user
	 * 
	 * @param message
	 * @param text
	 */
	public void sendMessageToUser(String chatId, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(chatId);
		sendMessage.enableMarkdown(true);
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

}