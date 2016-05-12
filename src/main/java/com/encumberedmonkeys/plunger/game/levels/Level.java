package com.encumberedmonkeys.plunger.game.levels;

import java.util.List;

import com.encumberedmonkeys.plunger.game.items.Item;

public abstract class Level {
    protected String id;
    protected List<Item> objects;

    public List<Item> getObjects(){
        return objects;
    };
}
