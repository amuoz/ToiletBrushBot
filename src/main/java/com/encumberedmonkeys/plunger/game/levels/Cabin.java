package com.encumberedmonkeys.plunger.game.levels;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Letrina;
import com.encumberedmonkeys.plunger.game.items.Papel;

import java.util.ArrayList;

public class Cabin extends Level {
	public Cabin(Game game) {
		id = "Cabin";
		if (objects == null)
			objects = new ArrayList<>();
		Letrina letrina = new Letrina();
		objects.add(letrina);
		objects.add(new Papel(game));

	}
}
