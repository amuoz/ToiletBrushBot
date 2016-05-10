package com.encumberedmonkeys.plunger;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Command for the bots
 * @date 20 of June of 2015
 */
public class Commands {
	public static final String commandInitChar = "/";

	/// Transifex iOS command
	public static final String transifexiOSCommand = commandInitChar + "langios";
	/// Transifex android command
	public static final String transifexAndroidCommand = commandInitChar + "langdroid";
	/// Transifex android command
	public static final String transifexTDesktop = commandInitChar + "langdesk";
	/// Transifex android command
	public static final String transifexWebogram = commandInitChar + "langweb";
	/// Transifex android command
	public static final String transifexWP = commandInitChar + "langwp";
	/// Transifex android command
	public static final String transifexOSX = commandInitChar + "langosx";
	/// Transifex android support command
	public static final String transifexAndroidSupportCommand = commandInitChar + "langtestdroid";

	/// Help command
	public static final String help = commandInitChar + "help";
	/// Start command
	public static final String startCommand = commandInitChar + "start";
	/// List command
	public static final String listCommand = commandInitChar + "list";
	/// Set Language command
	public static final String setLanguageCommand = commandInitChar + "language";
	public static final String STOPCOMMAND = commandInitChar + "stop";

	// Mis comandos
	public static final String saluda = commandInitChar + "saluda";
	// Plunger commands
	public static final String usarCommand = commandInitChar + "usar";
	public static final String examinarCommand = commandInitChar + "examinar";
	public static final String cogerCommand = commandInitChar + "coger";
	public static final String hablarCommand = commandInitChar + "hablar";
}
