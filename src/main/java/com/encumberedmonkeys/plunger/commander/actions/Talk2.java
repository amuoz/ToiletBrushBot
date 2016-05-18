package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.services.LocationService;

public class Talk2 extends Action{
    
	private Integer dialogo;
	
	public Talk2(Game game, Item first, Integer dialogo){
        this.command = LocationService.getInstance().getString("command.talk");
        this.first = first;
        this.game = game;
        this.dialogo = dialogo;
    }

    @Override
    public void execute() {
        first.talk(dialogo);
    }
}
