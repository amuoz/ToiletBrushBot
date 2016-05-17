package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.services.LocationService;

public class Messages {
	public static String help(){return LocationService.getInstance().getString("command.help");}
	public static String start(){return LocationService.getInstance().getString("command.start");}
	public static String language(){return LocationService.getInstance().getString("command.language");}
	public static String noItem(){return LocationService.getInstance().getString("command.noItem");}
	public static String commandDoesntExist(){return LocationService.getInstance().getString("command.commandDoesntExist");}
	public static String itemNotExist(){return LocationService.getInstance().getString("command.itemDoesntExist");}
	public static String secondItemNotExist(){return LocationService.getInstance().getString("command.secondItemDoesntExist");}
	public static String tooMuchItems(){return LocationService.getInstance().getString("command.tooMuchItems");}

}
