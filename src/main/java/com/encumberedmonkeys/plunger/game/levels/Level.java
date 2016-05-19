package com.encumberedmonkeys.plunger.game.levels;

import com.encumberedmonkeys.plunger.game.entities.Entity;

import java.util.List;

public abstract class Level {
    protected String id;
    protected List<Entity> objects;

    public List<Entity> getObjects(){
        return objects;
    };
}
