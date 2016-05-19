package com.encumberedmonkeys.plunger.game.entities.character;

import java.util.HashMap;

import com.encumberedmonkeys.plunger.game.Game;

public class Pelo extends Character {

	public Pelo(Game game) {
		super(game);
		start = "dPelo1";
		actual = "";

		Dialog d1 = new Dialog("dPelo1");
		Dialog d2 = new Dialog("dPelo2");

		// dPelo1
		Conversation c1 = new Conversation("1");
		c1.setOption("¿Quién eres?");
		c1.setAnswer("_Pelo_: Soy tu primer *pelo* pubertoso, soy tu pelo de adolescencia.");
		c1.setDialog(d1.getName());
		c1.getOptionOff().add("1");
		c1.getOptionOn().add("2");
		c1.getOptionOn().add("3");

		Conversation c2 = new Conversation("2");
		c2.setOption("¿Puedo arrancarte de mi mejilla?");
		c2.setAnswer(
				"_Pelo_: Vale, pero primero te arranco yo las piernas.\n_Plunger_: Eso no suena demasiado bien...mejor lo dejamos estar.");
		c2.setDialog(d1.getName());
		c2.setActive(false);
		c2.getOptionOff().add("2");

		Conversation c3 = new Conversation("3");
		c3.setOption("Tengo algunas dudas a cerca de los pelos de adolescencia.");
		c3.setAnswer("_Pelo_: Adelante. Veamos hasta dónde llega tu ignorancia.");
		c2.setActive(false);
		// movemos a dPelo2
		c3.setDialog(d2.getName());
		
		Conversation c4 = new Conversation("4");
		c4.setOption("Adios Pubert.");
		c4.setAnswer("_Pubert_: Me encantó solo en casa, el momento del afeitado fué genial. ¡Adiós!");
		c4.setDialog(d1.getName());
		c4.setStop(true);

		d1.getConversations().put(c1.getId(), c1);
		d1.getConversations().put(c2.getId(), c2);
		d1.getConversations().put(c3.getId(), c3);
		d1.getConversations().put(c4.getId(), c4);

		// dPelo2
		c1 = new Conversation("1");
		c1.setOption("¿De qué color eres?");
		c1.setAnswer(
				"_Pelo_: Soy Concha, concha tu madre.\n_Plunger_: Ese color no existe.\n_Pelo_: Concha es un matiz del blanco que se asemeja al color de la concha de varios moluscos en la naturaleza (estúpido humano)");
		c1.setDialog(d2.getName());

		c2 = new Conversation("2");
		c2.setOption("¿Son todos los pelos igual de estúpidos?");
		c2.setAnswer("_Pelo_: Si hablamos con alguien que merezca la pena NO.");
		c2.setDialog(d2.getName());

		c3 = new Conversation("3");
		c3.setOption("¿A qué te dedicas en tu tiempo libre?");
		c3.setAnswer("_Pelo_ : Planeo conquistar el mundo y esclavizar a la raza humana. ¿Por qué?\n_Plunger_ : Por nada por nada. ¡Mucho ánimo!");
		c3.setDialog(d2.getName());

		c4 = new Conversation("4");
		c4.setOption("No tengo más preguntas");
		c4.setAnswer("_Pelo_: Demos gracias al cuero cabelludo.");
		// volvemos a dPelo1
		c4.setDialog(d1.getName());
		
		d2.getConversations().put(c1.getId(), c1);
		d2.getConversations().put(c2.getId(), c2);
		d2.getConversations().put(c3.getId(), c3);
		d2.getConversations().put(c4.getId(), c4);

		dialogs = new HashMap<String, Dialog>();
		dialogs.put(d1.getName(), d1);
		dialogs.put(d2.getName(), d2);
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
