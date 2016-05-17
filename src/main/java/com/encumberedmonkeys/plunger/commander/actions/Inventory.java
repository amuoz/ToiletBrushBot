package com.encumberedmonkeys.plunger.commander.actions;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.game.items.Item;
import com.encumberedmonkeys.plunger.services.LocationService;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;

import java.util.List;

public class Inventory extends Action {
    public Inventory(Game game){
        this.command = LocationService.getInstance().getString("command.inventory");
        this.game = game;
    }

    @Override
    public void execute() {
        String result = "";
        List<Item> inventory = game.getPlayer().getInventory();
        if (inventory.size() > 0) {
            for (Item inventoryItem : inventory) {
                result += inventoryItem.getName() + "\n";
            }

        } else {
            result += "No hay ningún objeto en tu inventario.";
        }
        ToiletBrushHandler.getInstance().sendMessageToUser(result);
    }
}
