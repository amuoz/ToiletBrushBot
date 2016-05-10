package com.encumberedmonkeys.plunger.game.items;

import com.encumberedmonkeys.plunger.game.Item;

public class Letrina extends Item {

	public Letrina() {
		this.nombre = "letrina";
		this.examinar = "Es el agujero de una sucia y mal oliente letrina turca.";
		this.usarActivo = "No había tiempo para descubrir cómo funcionaría aquel artefacto del diablo por lo que "
				+ "Plunger se avalanza sobre él, entaponando el agujero con su grasiento ojete.\n\n"
				+ "Debido al estado de éxtasis en el que se encuentra comienza a cantar, inconscientemente, la canción de los zurullitos...\n\n"
				+ "Un zurullito, dos zurullitos, tres zurullitos...repetía.";
		this.usarInactivo = "Cañerías limpias, no hay necesidad de volver a usarlo.";

		this.activo = true;
		this.coger = false;
	}

}
