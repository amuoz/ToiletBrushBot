package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Item;
import lombok.Data;

@Data
public abstract class Action {
    protected String command;
    protected Item first;
    protected Item second;
    protected Game game;
    public abstract void execute();
}
