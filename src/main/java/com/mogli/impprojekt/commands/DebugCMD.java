package com.mogli.impprojekt.commands;

import com.mogli.impprojekt.Main;

import java.io.IOException;

public class DebugCMD implements Command {

    @Override
    public void onCommand(String[] args) throws IOException {
        if(Main.getConfigManager().get("debugmode").toString().equalsIgnoreCase("true")) {
            Main.getConfigManager().set("debugmode", "false");
            System.out.println("[DEBUG] Debugmode disabled.");
        } else {
            Main.getConfigManager().set("debugmode", "true");
            System.out.println("[DEBUG] Debugmode enabled.");
        }
    }

}
