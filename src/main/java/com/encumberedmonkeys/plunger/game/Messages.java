package com.encumberedmonkeys.plunger.game;

import com.encumberedmonkeys.plunger.services.LocalisationService;

public class Messages {
	public static String help = LocalisationService.getInstance().getString("command.help");
	public static String start = LocalisationService.getInstance().getString("command.start");
	public static String language = LocalisationService.getInstance().getString("command.language");
	public static String noItem = LocalisationService.getInstance().getString("command.noItem");
	public static String commandDoesntExist = LocalisationService.getInstance().getString("command.commandDoesntExist");
	public static String itemNotExist = LocalisationService.getInstance().getString("command.itemDoesntExist");
}
