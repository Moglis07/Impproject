package com.mogli.impprojekt.commands;

import java.io.IOException;

public interface Command {

    public void onCommand(String[] args) throws IOException, ClassNotFoundException;

}
