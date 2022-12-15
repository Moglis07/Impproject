package com.mogli.impprojekt;

public enum CommandsUsage {
    prefix("Use prefix to show you the prefix\n or prefix <new prefix symbole> to change the prefix to another symbole"),
    help("Show all Commands"),
    exit("End the programm"),
    hufman("change something in hufman coding"),
    debug("activate the debug mode");


    public final String label;

    private CommandsUsage(String label) {
        this.label = label;
    }
}
