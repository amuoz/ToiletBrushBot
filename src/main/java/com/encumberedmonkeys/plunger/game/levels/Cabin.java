package com.encumberedmonkeys.plunger.game.levels;

import java.util.ArrayList;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Cordoneras;
import com.encumberedmonkeys.plunger.game.items.Escobilla;
import com.encumberedmonkeys.plunger.game.items.Letrina;
import com.encumberedmonkeys.plunger.game.items.Papel;

public class Cabin extends Level {
	public Cabin(Game game) {
		id = "Cabin";
		if (objects == null)
			objects = new ArrayList<>();

		// Items del nivel
		objects.add(new Letrina(game));
		objects.add(new Escobilla(game));
		objects.add(new Cordoneras(game));
		objects.add(new Papel(game));
	}
}
