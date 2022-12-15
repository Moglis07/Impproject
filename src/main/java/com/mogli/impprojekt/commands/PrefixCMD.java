package com.mogli.impprojekt.commands;

import com.mogli.impprojekt.Main;

import java.io.IOException;

public class PrefixCMD implements Command {
    @Override
    public void onCommand(String[] args) throws IOException {

        if(args.length == 0) {
            System.out.println("[PREFIX] The Command Prefix is " + Main.getConfigManager().get("prefix"));
        } else {
            System.out.println("[PREFIX] The Command Prefix changed to " + args[0]);
            Main.getConfigManager().set("prefix", args[0]);
        }

    }
}
