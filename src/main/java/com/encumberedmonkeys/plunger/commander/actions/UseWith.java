package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.services.LocationService;

public class UseWith extends Action {
    public UseWith(Game game, Item first, Item second){
        this.command = LocationService.getInstance().getString("command.use");
        this.first = first;
        this.second = second;
        this.game = game;
    }

    @Override
    public void execute() {
        first.use(second);
    }
}
