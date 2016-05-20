package com.encumberedmonkeys.plunger.updateshandlers;

import com.encumberedmonkeys.plunger.BotConfig;
import com.encumberedmonkeys.plunger.commander.Commander;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardHide;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

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

	@Getter
	private String chatId;
	@Getter
	private Integer messageId;

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

		try {
			Message message = update.getMessage();
			if (message != null && !message.getText().isEmpty()) {
				chatId = message.getChatId().toString();
				messageId = message.getMessageId();
				Commander.getInstance().execute(message);
			}

			// callback inline keyboard
			if (update.getCallbackQuery() != null) {
				AnswerCallbackQuery answerCallbackConfirmation = new AnswerCallbackQuery();
				answerCallbackConfirmation.setCallbackQueryId(update.getCallbackQuery().getId());
				chatId = update.getCallbackQuery().getMessage().getChatId().toString();
				messageId = update.getCallbackQuery().getMessage().getMessageId();
				Commander.getInstance().executeCallback(update.getCallbackQuery());
				answerCallbackQuery(answerCallbackConfirmation);
			}

		} catch (Exception e) {
			log.error("Error in Plunger bot", e);
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

	public void sendKeyboardMessageToUser(String text, List<KeyboardRow> replies) {

		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(chatId);
		sendMessage.enableMarkdown(true);
		sendMessage.setText(text);

		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		replyKeyboardMarkup.setKeyboard(replies);
		//replyKeyboardMarkup.setOneTimeKeyboad(true);
		replyKeyboardMarkup.setResizeKeyboard(true);

		sendMessage.setReplayMarkup(replyKeyboardMarkup);

		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

	public void sendInlineKeyboardMessageToUser(String text, List<List<InlineKeyboardButton>> replies) {

		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(chatId);
		sendMessage.enableMarkdown(true);
		sendMessage.setText(text);

		InlineKeyboardMarkup replyInlineKeyboardMarkup = new InlineKeyboardMarkup();
		replyInlineKeyboardMarkup.setKeyboard(replies);

		sendMessage.setReplayMarkup(replyInlineKeyboardMarkup);

		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

	public void editMessageTextToUser(String text, List<List<InlineKeyboardButton>> replies) {
		EditMessageText editMessageText = new EditMessageText();
		editMessageText.setChatId(chatId);
		editMessageText.setMessageId(messageId);
		editMessageText.enableMarkdown(true);
		editMessageText.setText(text);

		InlineKeyboardMarkup replyInlineKeyboardMarkup = new InlineKeyboardMarkup();
		replyInlineKeyboardMarkup.setKeyboard(replies);
		editMessageText.setReplyMarkup(replyInlineKeyboardMarkup);

		try {
			editMessageText(editMessageText);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

	public void editMessageReplyMarkupToUser(List<List<InlineKeyboardButton>> replies) {

		EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
		editMessageReplyMarkup.setChatId(chatId);
		editMessageReplyMarkup.setMessageId(messageId);

		InlineKeyboardMarkup replyInlineKeyboardMarkup = new InlineKeyboardMarkup();
		replyInlineKeyboardMarkup.setKeyboard(replies);
		editMessageReplyMarkup.setReplyMarkup(replyInlineKeyboardMarkup);

		try {
			editMessageReplyMarkup(editMessageReplyMarkup);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

}