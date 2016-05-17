package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.services.LocalisationService;

public class Messages {
	public static String help(){return LocalisationService.getInstance().getString("command.help");}
	public static String start(){return LocalisationService.getInstance().getString("command.start");}
	public static String language(){return LocalisationService.getInstance().getString("command.language");}
	public static String noItem(){return LocalisationService.getInstance().getString("command.noItem");}
	public static String commandDoesntExist(){return LocalisationService.getInstance().getString("command.commandDoesntExist");}
	public static String itemNotExist(){return LocalisationService.getInstance().getString("command.itemDoesntExist");}
	public static String secondItemNotExist(){return LocalisationService.getInstance().getString("command.secondItemDoesntExist");}
	public static String tooMuchItems(){return LocalisationService.getInstance().getString("command.tooMuchItems");}

}
