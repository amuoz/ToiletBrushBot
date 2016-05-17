package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.services.LocationService;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

public class Shit extends Action {
    public Shit(Game game){
        this.command = LocationService.getInstance().getString("command.shit");
        this.game = game;
    }

    @Override
    public void execute() {
        ToiletBrushHandler.getInstance().sendMessageToUser((LocationService.getInstance().getString("letrina.cagar")));
        ToiletBrushHandler.getInstance().sendMessageToUser((LocationService.getInstance().getString("plunger.atascado")));
    }
}
