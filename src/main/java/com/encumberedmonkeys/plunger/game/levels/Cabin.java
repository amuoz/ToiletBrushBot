package com.encumberedmonkeys.plunger.game.levels;

import java.util.ArrayList;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Cartel;
import com.encumberedmonkeys.plunger.game.items.Cordoneras;
import com.encumberedmonkeys.plunger.game.items.Escobilla;
import com.encumberedmonkeys.plunger.game.items.Letrina;
import com.encumberedmonkeys.plunger.game.items.Manivela;
import com.encumberedmonkeys.plunger.game.items.Papelera;
import com.encumberedmonkeys.plunger.game.items.Pelo;
import com.encumberedmonkeys.plunger.game.items.Puerta;

public class Cabin extends Level {
	public Cabin(Game game) {
		id = "Cabin";
		if (objects == null)
			objects = new ArrayList<>();

		// Items del nivel
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
