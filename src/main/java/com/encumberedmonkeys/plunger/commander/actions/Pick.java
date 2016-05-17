package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.services.LocalisationService;

public class Pick extends Action{
    public Pick(Game game, Item first){
        this.command = LocalisationService.getInstance().getString("command.pick");
        this.first = first;
        this.game = game;
    }

    @Override
    public void execute() {
        first.pick();
    }
}
