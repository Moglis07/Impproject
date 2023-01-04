package com.mogli.impprojekt.commands;

import com.mogli.impprojekt.Main;
import com.mogli.impprojekt.utils.ConfigManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.stream.Stream;

public class CommandManager {

    private HashMap<String, Command> commands;
    private ConfigManager configManager;

    public CommandManager() throws IOException {
        configManager = Main.getConfigManager();
        commands = new HashMap<>();
    }

    public boolean runCommand(String command) throws IOException, ClassNotFoundException {

        if(!Main.waitingOnAnswer) {
            if(command.startsWith((String) configManager.get("prefix"))) {

                String[] splittedCommand = command.split(" ");
                String cmd = splittedCommand[0].replace((CharSequence) configManager.get("prefix"), "");

                if(commands.containsKey(cmd)) {
                    String args = "";

                    for (int i = command.split(" ").length - 1; i >= 0; i--) {
                        if(i > 0) {
                            args = args + splittedCommand[i];
                        }
                    }


                    if(commands.containsKey(cmd)) {
                        if(args.length() > 0) {
                            commands.get(cmd).onCommand(args.split(" "));
                        } else {
                            commands.get(cmd).onCommand(new String[]{});
                        }
                    }
                } else {
                    System.out.println("[COMMAND] Unknown Command. Please use '" + configManager.get("prefix") + "help' to get a List of all Commands.");
                }



            }
        }

        return false;
    }

    public void registerCommand(String commandName, Command command) throws InterruptedException {
        commands.put(commandName, command);
        System.out.println("[COMMANDS] " + command.getClass().getName() + " registered.");
        Thread.sleep(200);
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }
}
