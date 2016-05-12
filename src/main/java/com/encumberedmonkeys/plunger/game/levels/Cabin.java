package com.encumberedmonkeys.plunger.game.levels;

import com.encumberedmonkeys.plunger.game.items.Letrina;
import com.encumberedmonkeys.plunger.game.items.Papel;

import java.util.ArrayList;

public class Cabin extends Level{
    public Cabin(){
        id = "Cabin";
        if(objects == null) objects = new ArrayList<>();
        objects.add(new Papel());
        objects.add(new Letrina());
    }
}
