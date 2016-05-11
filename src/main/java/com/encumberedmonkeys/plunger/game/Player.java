package com.encumberedmonkeys.plunger.game;

import lombok.Getter;

import java.util.List;

import com.encumberedmonkeys.plunger.game.items.Item;

public class Player {
    @Getter
    private List<Item> inventory;
}
