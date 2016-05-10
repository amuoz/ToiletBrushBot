package com.encumberedmonkeys.plunger.updateshandlers;

import com.encumberedmonkeys.plunger.Commands;
import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.Messages;
import com.encumberedmonkeys.plunger.game.items.Objeto;
import lombok.extern.slf4j.Slf4j;
import com.encumberedmonkeys.plunger.BotConfig;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

/**
 * Manejador LongPolling para ToiletBrushBot.
 * 
 * @author AMUNOZ
 *
 */
@Slf4j
public class ToiletBrushHandler extends TelegramLongPollingBot {

	private Game juego;
	private String comandoActual;

	@Override
	public String getBotUsername() {
		return BotConfig.TOILET_BRUSH_USERNAME;
	}

	@Override
	public String getBotToken() { return BotConfig.TOILET_BRUSH_TOKEN; }

	@Override
	public void onUpdateReceived(Update update) {

		// Command handling
		Message message = update.getMessage();
		if (message != null && message.hasText()) {

			String mensaje = message.getText();

			// startcmd
			if (isStart(mensaje)) {
				juego = new Game();
				sendMessageToBot(message, Messages.startMessage);
				// helpcmd
			} else if (isHelp(mensaje)) {
				sendMessageToBot(message, Messages.helpMessage);
			}
			// comandos: examinar,coger,usar,hablar
			else if (isComando(mensaje)) {
				comandoActual = mensaje;
				log.info("COMANDO ACTUAL: " + comandoActual);
				sendMessageToBot(message, getMensajeComando(mensaje));
			}
			// EXAMINAR objeto
			else if (isExaminar()) {
				Objeto objeto = juego.buscarPorNombre(mensaje);
				if (objeto != null) {
					sendMessageToBot(message, objeto.getExaminar());
				} else {
					sendMessageToBot(message, Messages.noExisteMessage);
				}

				// reset comando actual
				comandoActual = "";
			}
			// USAR objeto
			else if (isUsar()) {
				Objeto objeto = juego.buscarPorNombre(mensaje);
				if (objeto != null) {
					if (objeto.equals(juego.letrina)) {
						// Activamos el papel
						juego.papel.setActivo(true);
					}
					sendMessageToBot(message, objeto.usar());
				} else {
					sendMessageToBot(message, Messages.noExisteMessage);
				}

				// reset comando actual
				comandoActual = "";
			}
			// COGER objeto
			else if (isCoger()) {
				Objeto objeto = juego.buscarPorNombre(mensaje);
				if (objeto != null && objeto.isActivo() && objeto.isCoger() && !objeto.isLoTengo()) {
					objeto.coger();
					sendMessageToBot(message, Messages.cogidoMessage);
				} else {
					sendMessageToBot(message, Messages.noExisteMessage);
				}

				// reset comando actual
				comandoActual = "";
			}
			// HABLAR objeto
			else if (isHablar()) {

				// reset comando actual
				comandoActual = "";
			}

		}

	}

	private String getMensajeComando(String message) {
		if (isExaminar(message))
			return Messages.examinarMessage;
		else if (isCoger(message))
			return Messages.cogerMessage;
		else if (isUsar(message))
			return Messages.usarMessage;
		else if (isHablar(message))
			return Messages.hablarMessage;
		else
			return Messages.noExisteComandoMessage;
	}

	private boolean isStart(String message) {
		return message.startsWith(Commands.startCmd);
	}

	private boolean isHelp(String message) {
		return message.startsWith(Commands.helpCmd);
	}

	private boolean isExaminar(String message) {
		return message.startsWith(Commands.examineCmd);
	}

	private boolean isUsar(String message) {
		return message.startsWith(Commands.useCmd);
	}

	private boolean isCoger(String message) {
		return message.startsWith(Commands.pickupCmd);
	}

	private boolean isHablar(String message) {
		return message.startsWith(Commands.talkCmd);
	}

	private boolean isComando(String message) {
		return isExaminar(message) || isUsar(message) || isCoger(message) || isHablar(message);
	}

	private boolean isExaminar() {
		return comandoActual.equals(Commands.examineCmd);
	}

	private boolean isUsar() {
		return comandoActual.equals(Commands.useCmd);
	}

	private boolean isCoger() {
		return comandoActual.equals(Commands.pickupCmd);
	}

	private boolean isHablar() {
		return comandoActual.equals(Commands.talkCmd);
	}

	private void sendMessageToBot(Message message, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.enableMarkdown(true);
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			log.error("Error in telegram API", e);
		}
	}

}