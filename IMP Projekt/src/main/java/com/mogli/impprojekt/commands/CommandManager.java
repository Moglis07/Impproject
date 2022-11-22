package com.mogli.impprojekt.commands;

import com.mogli.impprojekt.Main;
import com.mogli.impprojekt.utils.ConfigManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class CommandManager {

    private HashMap<String, Command> commands;
    private ConfigManager configManager;

    public CommandManager() throws IOException {
        configManager = Main.getConfigManager();
        commands = new HashMap<>();
    }

    public boolean runCommand(String command) {
        if(command.startsWith((String) configManager.get("prefix"))) {
            System.out.println(configManager.get("prefix"));
            System.out.println(command);
            command.substring(1);
            System.out.println(command);
            String[] splitCommand = command.split(" ");
            System.out.println(splitCommand);
            String cmd = splitCommand[0];

            if(commands.containsKey(cmd)) {
                System.out.println(cmd);
                commands.get(cmd).onCommand(splitCommand);
                return true;
            } else {
                System.out.println("IMP: This command is not existing");
            }

        }

        return false;
    }

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }



}
