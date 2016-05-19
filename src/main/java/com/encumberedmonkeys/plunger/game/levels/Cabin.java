package com.encumberedmonkeys.plunger.game.levels;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.character.Pelo;
import com.encumberedmonkeys.plunger.game.entities.items.*;

import java.util.ArrayList;

public class Cabin extends Level {
	public Cabin(Game game) {
		id = "Cabin";
		if (objects == null)
			objects = new ArrayList<>();

		// Entities del nivel
		objects.add(new Letrina(game));
		objects.add(new Cartel(game));
		objects.add(new Escobilla(game));
		objects.add(new Cordoneras(game));
		// objects.add(new Papel(game));
		objects.add(new Manivela(game));
		objects.add(new Puerta(game));
		objects.add(new Papelera(game));
		objects.add(new Pelo(game));
	}
}
