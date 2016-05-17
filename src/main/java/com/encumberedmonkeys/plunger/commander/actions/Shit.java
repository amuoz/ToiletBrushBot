package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.services.LocalisationService;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

public class Shit extends Action {
    public Shit(Game game){
        this.command = LocalisationService.getInstance().getString("command.shit");
        this.game = game;
    }

    @Override
    public void execute() {
        ToiletBrushHandler.getInstance().sendMessageToUser((LocalisationService.getInstance().getString("letrina.cagar")));
        ToiletBrushHandler.getInstance().sendMessageToUser((LocalisationService.getInstance().getString("plunger.atascado")));
    }
}
