package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;
import com.encumberedmonkeys.plunger.game.entities.items.Item;
import com.encumberedmonkeys.plunger.services.LocationService;

public class Talk extends Action{
    public Talk(Game game, Entity first){
        this.command = LocationService.getInstance().getString("command.talk");
        this.first = first;
        this.game = game;
    }

    @Override
    public void execute() {
        first.talk();
    }
}
