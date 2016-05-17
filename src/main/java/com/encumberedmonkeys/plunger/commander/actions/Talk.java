package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.services.LocalisationService;

public class Talk extends Action{
    public Talk(Game game, Item first){
        this.command = LocalisationService.getInstance().getString("command.talk");
        this.first = first;
        this.game = game;
    }

    @Override
    public void execute() {
        first.talk();
    }
}
