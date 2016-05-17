package com.encumberedmonkeys.plunger.updateshandlers;

import com.encumberedmonkeys.plunger.BotConfig;
import com.encumberedmonkeys.plunger.commander.Commander;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.methods.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.ReplyKeyboardHide;
import org.telegram.telegrambots.api.objects.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.ArrayList;
import java.util.List;

/**
 * Manejador LongPolling para ToiletBrushBot.
 * 
 * @author muoz & thenanox
 *
 */
@Slf4j
public class ToiletBrushHandler extends TelegramLongPollingBot {

	public static final ToiletBrushHandler HANDLER = new ToiletBrushHandler();

	public static ToiletBrushHandler getInstance() {
		return HANDLER;
	}

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
		Message message = update.getMessage();
		if (message != null && !message.getText().isEmpty()) {
			chatId = message.getChatId().toString();
			Commander.getInstance().execute(message);
		}
	}

	public void sendMessageToUser(String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(chatId);
		sendMessage.enableMarkdown(true);
		sendMessage.setText(text);
		
		ReplyKeyboardHide replyKeyboardHide = new ReplyKeyboardHide();
		replyKeyboardHide.setHideKeyboard(true);
		sendMessage.setReplayMarkup(replyKeyboardHide);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

	public void sendPhotoToUser(String photoId) {
		SendPhoto sendPhoto = new SendPhoto();
		sendPhoto.setChatId(chatId);
		sendPhoto.setPhoto(photoId);
		try {
			this.sendPhoto(sendPhoto);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

	public void sendKeyboardMessageToUser(String text, List<String> replies) {

		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(chatId);
		sendMessage.enableMarkdown(true);
		sendMessage.setText(text);

		List<List<String>> keyboard = new ArrayList<>();
		keyboard.add(replies);
		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		replyKeyboardMarkup.setKeyboard(keyboard);

		sendMessage.setReplayMarkup(replyKeyboardMarkup);

		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

}