package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

import lombok.Getter;

public class Letrina extends Item {

<<<<<<< HEAD
	@Getter
	private final String examineBeforeShitMsg = "Es el agujero de una sucia y mal oliente letrina turca.";
	@Getter
	private final String examineAfterShitMsg = "¡Sñr. Mojón está a remojo!";
	@Getter
	private final String useBeforeShitMsg = "No había tiempo para descubrir cómo funcionaría aquel artefacto del diablo por lo que "
			+ "Plunger se avalanza sobre él, entaponando el agujero con su grasiento ojete.\n\n"
			+ "Debido al estado de éxtasis en el que se encuentra comienza a cantar, inconscientemente, la canción de los zurullitos...\n\n"
			+ "Un zurullito, dos zurullitos, tres zurullitos...repetía.";
	@Getter
	private final String useAfterShitMsg = "Cañerías limpias, no hay necesidad de volver a usarlo.";
	@Getter
	private final String pickLetrinaMsg = "Eso está bien donde está.";
	@Getter
	private final String talkLetrinaMsg = "Hooooooooooola ¿Hay alguien ahí?";
=======
	public Letrina() {
		this.nombre = gameResources.getString("letrina.name");
		this.examinar = gameResources.getString("letrina.examine");
		this.usarActivo = gameResources.getString("letrina.activeUse");
		this.usarInactivo = gameResources.getString("letrina.inactiveUse");
>>>>>>> branch 'master' of https://github.com/amuoz/ToiletBrushBot

	private boolean usada;

	public Letrina() {
		name = "letrina";

		useMsg = getUseBeforeShitMsg();
		examineMsg = getExamineBeforeShitMsg();
		pickMsg = getPickLetrinaMsg();

		usada = false; // inicialmente al usar letrina caga
	}

	@Override
	public void examine() {
		ToiletBrushHandler.getInstance().sendMessageToUser(examineMsg);
	}

	@Override
	public void use() {
		ToiletBrushHandler.getInstance().sendMessageToUser(useMsg);

		// La primera vez que se usa
		if (!usada) {
			useMsg = getUseAfterShitMsg();
			examineMsg = getExamineAfterShitMsg();
			usada = true;
		}
	}

	@Override
	public void pick() {
		ToiletBrushHandler.getInstance().sendMessageToUser(pickMsg);
	}

	public void talk() {
		ToiletBrushHandler.getInstance().sendMessageToUser(getTalkLetrinaMsg());
	}

}
