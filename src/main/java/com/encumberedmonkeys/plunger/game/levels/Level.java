package com.encumberedmonkeys.plunger.game.levels;

import com.encumberedmonkeys.plunger.game.items.Item;

import java.util.List;

public abstract class Level {
    protected String id;
    protected List<Item> objects;

    public List<Item> getObjects(){
        return objects;
    };
}
