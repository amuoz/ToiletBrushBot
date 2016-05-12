package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.Commands;

public class Messages {

	public static final String help = "Usa este bot para jugar a la aventura gráfica de la super escobilla.\n\n"
			+ "Puedes utilizar los siguientes comandos de telegram:\n" + Commands.startCmd + " : empezar a jugar\n"
			+ Commands.helpCmd + " : mostrar ayuda\n\n"
			+ "Para ayudar a nuestro gordito amigo Plunger en su aventura debes utilizar una acción seguida de un objeto.\n"
			+ "Por ejemplo: " + Commands.useCmd + " trompeta\n\n" + "Cuentas con las siguientes acciones:\n\n"
			+ Commands.pickCmd + " : coger un objeto\n" + Commands.examineCmd + " : examinar algo\n" + Commands.talkCmd
			+ " : hablar con\n" + Commands.useCmd + " : usar un objeto";

	public static final String start = "Plunger se encuentra frente a la gran caseta letrina del campamento.\n"
			+ "Nunca la había imaginado así de enorme, perdiéndose en el estrellado cielo.\n\n"
			+ "Está a punto de dar media vuelta, pero no aguanta más ¡se está cagando!\n\n"
			+ "Con un arrebato se introduce en la caseta y cierra la puerta a toda ostia "
			+ "echando el pestillo de aquella manera por el ansia de la cagada.\n\n"
			+ "Al darse al vuelta en busca de la taza de váter que le salvará la vida queda estupefacto al observar aquel agujero asqueroso y mal oliente.\n\n"
			+ "Se trata de una letrina turca con papel mojado en el suelo.";

	public static final String noItem = "Debes indicar el nombre de un objeto.";
	public static final String commandNotExist = "El comando indicado no existe.";
	public static final String itemNotExist = "El objeto indicado no existe.";

}
