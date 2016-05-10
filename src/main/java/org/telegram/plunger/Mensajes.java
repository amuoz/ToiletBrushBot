package org.telegram.plunger;

import org.telegram.Commands;

public class Mensajes {

	public static final String helpMessage = "Usa este bot para jugar a la aventura gráfica de la super escobilla.\n\n"
			+ "Utiliza los siguientes comandos para ayudar a nuestra gordito amigo Plunger en su aventura:\n\n"
			+ Commands.startCommand + " : empezar a jugar\n" + Commands.help + " : mostrar ayuda\n"
			+ Commands.cogerCommand + " : coger un objeto\n" + Commands.examinarCommand + " : examinar algo\n"
			+ Commands.hablarCommand + " : hablar con\n" + Commands.usarCommand + " : usar un objeto\n";

	public static final String startMessage = "Plunger se encuentra frente a la gran caseta letrina del campamento.\n"
			+ "Nunca la había imaginado así de enorme, perdiéndose en el estrellado cielo.\n\n"
			+ "Está a punto de dar media vuelta, pero no aguanta más ¡se está cagando!\n\n"
			+ "Con un arrebato se introduce en la caseta y cierra la puerta a toda ostia "
			+ "echando el pestillo de aquella manera por el ansia de la cagada.\n\n"
			+ "Al darse al vuelta en busca de la taza de váter que le salvará la vida queda estupefacto al observar aquel agujero asqueroso y mal oliente.\n\n"
			+ "Se trata de una letrina turca con papel mojado en el suelo.";

	public static final String examinarMessage = "¿Qué quieres examinar?";
	public static final String usarMessage = "¿Qué quieres usar?";
	public static final String cogerMessage = "¿Qué quieres coger?";
	public static final String hablarMessage = "¿A quién quieres hablar?";

	public static final String cogidoMessage = "Vale, lo he cogido.";

	public static final String noExisteComandoMessage = "El comando indicado no existe.";
	public static final String noExisteMessage = "El objeto que dices no existe.";

}
