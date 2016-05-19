package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.entities.Entity;
import com.encumberedmonkeys.plunger.services.LocationService;

public class Examine extends Action {
    public Examine(Game game, Entity first){
        command = LocationService.getInstance().getString("command.examine");
        this.first = first;
        this.game = game;
    }

    @Override
    public void execute() {
        first.examine();
    }
}
