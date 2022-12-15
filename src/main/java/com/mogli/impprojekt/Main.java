package com.mogli.impprojekt;

import com.mogli.impprojekt.commands.CommandManager;
import com.mogli.impprojekt.commands.DebugCMD;
import com.mogli.impprojekt.commands.ExitCMD;
import com.mogli.impprojekt.commands.PrefixCMD;
import com.mogli.impprojekt.utils.ConfigManager;

import java.io.IOException;

public class Main {

    public static ConfigManager configManager;
    private static CommandManager commandManager;
    private static ConsoleManager consoleManager;
    public static boolean waitingOnAnswer;

    public static void main(String[] args) throws IOException, InterruptedException {
        configManager = new ConfigManager();
        commandManager = new CommandManager();
        consoleManager = new ConsoleManager();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------\n" +
                "ooooo ooo        ooooo ooooooooo.        ooooooooo.   ooooooooo.     .oooooo.      oooo oooooooooooo   .oooooo.   ooooooooooooo     \n" +
                "`888' `88.       .888' `888   `Y88.      `888   `Y88. `888   `Y88.  d8P'  `Y8b     `888 `888'     `8  d8P'  `Y8b  8'   888   `8\n" +
                " 888   888b     d'888   888   .d88'       888   .d88'  888   .d88' 888      888     888  888         888               888     \n" +
                " 888   8 Y88. .P  888   888ooo88P'        888ooo88P'   888ooo88P'  888      888     888  888oooo8    888               888     \n" +
                " 888   8  `888'   888   888               888          888`88b.    888      888     888  888    \"    888               888     \n" +
                " 888   8    Y     888   888               888          888  `88b.  `88b    d88'     888  888       o `88b    ooo       888      \n" +
                "o888o o8o        o888o o888o             o888o        o888o  o888o  `Y8bood8P'  .o. 88P o888ooooood8  `Y8bood8P'      o888o     \n" +
                "-------------------------------------------------------------------------------------------------------------------------------\n\ncreated by Malu, Greta and Moritz\n\n\n");

        Thread.sleep(1000);
        registerCommands();

        System.out.println("[PREFIX] THE Command Prefix is '" + configManager.get("prefix") + "'");
        waitingOnAnswer = false;
    }

    public static void registerCommands() throws InterruptedException {
        System.out.println("[COMMANDS] initializing commands...");
        commandManager.registerCommand("exit", new ExitCMD());
        commandManager.registerCommand("debug", new DebugCMD());
        commandManager.registerCommand("prefix", new PrefixCMD());
        System.out.println("[COMMANDS] All Commands loaded.\n");
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static CommandManager getCommandManager() {
        return commandManager;
    }
}