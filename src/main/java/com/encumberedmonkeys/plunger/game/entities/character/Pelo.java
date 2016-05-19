package com.encumberedmonkeys.plunger.game.entities.character;

import com.encumberedmonkeys.plunger.game.Game;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pelo extends Character {

	public Pelo(Game game) {
		super(game);
		start = "dPelo1";
		actual = "";
		Dialog d1 = new Dialog("dPelo1");
		
		Conversation c1 = new Conversation();
		c1.setOption("¿Quién eres?");
		c1.setAnswer("_Pelo_: Soy tu primer *pelo* pubertoso, soy tu pelo de adolescencia.");
		c1.setDialog(d1.getName());
		
		Conversation c2 = new Conversation();
		c2.setOption("¿Puedo arrancarte de mi mejilla?");
		c2.setAnswer("_Pelo_: Vale, pero primero te arranco yo las piernas.\n_Plunger_: Eso no suena demasiado bien...mejor lo dejamos estar.");
		c2.setDialog(d1.getName());
		
		Conversation c3 = new Conversation();
		c3.setOption("Adios Pubert.");
		c3.setAnswer("_Pubert_: Me encantó solo en casa, el momento del afeitado fué genial. ¡Adiós!");
		c3.setDialog(d1.getName());
		c3.setStop(true);
		
		d1.getConversations().add(c1);
		d1.getConversations().add(c2);
		d1.getConversations().add(c3);
		
		dialogs = new HashMap<String, Dialog>();
		dialogs.put(d1.getName(), d1);
	}

	@Override
	public String getName() {
		return getMsg("pelo.name");
	}

	@Override
	public void examine() {
		sendMessageToUser(getMsg("pelo.examine"));
	}
}
