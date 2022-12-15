package com.mogli.impprojekt.commands;

public class ExitCMD implements Command {
    @Override
    public void onCommand(String[] args) {
        System.out.println("Save and Exit");
        System.exit(0);
    }
}
