package org.telegram.updateshandlers;

import org.apache.log4j.Logger;
import org.telegram.BotConfig;
import org.telegram.Commands;
import org.telegram.plunger.Juego;
import org.telegram.plunger.Mensajes;
import org.telegram.plunger.objetos.Objeto;
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
public class ToiletBrushHandler extends TelegramLongPollingBot {

	private static final Logger LOG = Logger.getLogger(ToiletBrushHandler.class);

	private Juego juego;
	private String comandoActual;

	@Override
	public String getBotUsername() {
		return BotConfig.USERNAMEMYPROJECT;
	}

	@Override
	public String getBotToken() {
		return BotConfig.TOKENMYPROJECT;
	}

	@Override
	public void onUpdateReceived(Update update) {

		// Command handling
		Message message = update.getMessage();
		if (message != null && message.hasText()) {

			String mensaje = message.getText();

			// start
			if (isStart(mensaje)) {
				juego = new Juego();
				enviarMensaje(message, Mensajes.startMessage);
				// help
			} else if (isHelp(mensaje)) {
				enviarMensaje(message, Mensajes.helpMessage);
			}
			// comandos: examinar,coger,usar,hablar
			else if (isComando(mensaje)) {
				comandoActual = mensaje;
				LOG.info("COMANDO ACTUAL: " + comandoActual);
				enviarMensaje(message, getMensajeComando(mensaje));
			}
			// EXAMINAR objeto
			else if (isExaminar()) {
				Objeto objeto = juego.buscarPorNombre(mensaje);
				if (objeto != null) {
					enviarMensaje(message, objeto.getExaminar());
				} else {
					enviarMensaje(message, Mensajes.noExisteMessage);
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
					enviarMensaje(message, objeto.usar());
				} else {
					enviarMensaje(message, Mensajes.noExisteMessage);
				}

				// reset comando actual
				comandoActual = "";
			}
			// COGER objeto
			else if (isCoger()) {
				Objeto objeto = juego.buscarPorNombre(mensaje);
				if (objeto != null && objeto.isActivo() && objeto.isCoger() && !objeto.isLoTengo()) {
					objeto.coger();
					enviarMensaje(message, Mensajes.cogidoMessage);
				} else {
					enviarMensaje(message, Mensajes.noExisteMessage);
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

	private String getMensajeComando(String mensaje) {
		if (isExaminar(mensaje))
			return Mensajes.examinarMessage;
		else if (isCoger(mensaje))
			return Mensajes.cogerMessage;
		else if (isUsar(mensaje))
			return Mensajes.usarMessage;
		else if (isHablar(mensaje))
			return Mensajes.hablarMessage;
		else
			return Mensajes.noExisteComandoMessage;
	}

	private boolean isStart(String mensaje) {
		return mensaje.startsWith(Commands.startCommand);
	}

	private boolean isHelp(String mensaje) {
		return mensaje.startsWith(Commands.help);
	}

	private boolean isExaminar(String mensaje) {
		return mensaje.startsWith(Commands.examinarCommand);
	}

	private boolean isUsar(String mensaje) {
		return mensaje.startsWith(Commands.usarCommand);
	}

	private boolean isCoger(String mensaje) {
		return mensaje.startsWith(Commands.cogerCommand);
	}

	private boolean isHablar(String mensaje) {
		return mensaje.startsWith(Commands.hablarCommand);
	}

	private boolean isComando(String mensaje) {
		return isExaminar(mensaje) || isUsar(mensaje) || isCoger(mensaje) || isHablar(mensaje);
	}

	private boolean isExaminar() {
		return comandoActual.equals(Commands.examinarCommand);
	}

	private boolean isUsar() {
		return comandoActual.equals(Commands.usarCommand);
	}

	private boolean isCoger() {
		return comandoActual.equals(Commands.cogerCommand);
	}

	private boolean isHablar() {
		return comandoActual.equals(Commands.hablarCommand);
	}

	/**
	 * Envía un mensaje de texto al usuario actual
	 * 
	 * @param message
	 *            Mensaje recibido
	 * @param text
	 *            Texto a enviar
	 */
	private void enviarMensaje(Message message, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.enableMarkdown(true);
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			LOG.error(e);
			e.printStackTrace();
		}
	}

}