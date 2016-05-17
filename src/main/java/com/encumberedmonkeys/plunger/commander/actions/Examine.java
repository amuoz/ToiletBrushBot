package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.services.LocalisationService;

public class Examine extends Action {
    public Examine(Game game, Item first){
        command = LocalisationService.getInstance().getString("command.examine");
        this.first = first;
        this.game = game;
    }

    @Override
    public void execute() {
        first.examine();
    }
}
