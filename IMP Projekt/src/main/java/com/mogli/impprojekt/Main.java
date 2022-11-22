package com.mogli.impprojekt;

import com.mogli.impprojekt.commands.CommandManager;
import com.mogli.impprojekt.commands.test;
import com.mogli.impprojekt.utils.ConfigManager;

import java.io.Console;
import java.io.IOException;

public class Main {

    public static ConfigManager configManager;
    private static CommandManager commandManager;
    private static ConsoleManager consoleManager;

    public static void main(String[] args) throws IOException {
        configManager = new ConfigManager();
        commandManager = new CommandManager();
        consoleManager = new ConsoleManager();
        System.out.println("[IMP] started!");
    }

    public void registerCommands() {
        commandManager.registerCommand("test", new test());
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }


}