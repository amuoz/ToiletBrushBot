package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.services.LocalisationService;

public class Use extends Action{
    public Use(Game game, Item first){
        this.command = LocalisationService.getInstance().getString("command.use");
        this.first = first;
        this.game = game;
    }

    @Override
    public void execute() {
        first.use();
    }
}
