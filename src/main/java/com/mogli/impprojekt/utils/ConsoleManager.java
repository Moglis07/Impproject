package com.mogli.impprojekt.utils;

import com.mogli.impprojekt.Main;
import com.mogli.impprojekt.commands.CommandManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleManager {

    private String lastMessage;
    private String lastConsoleMessage;
    private CommandManager commandManager;

    public ConsoleManager() throws IOException {
        commandManager = Main.getCommandManager();

        startConsoleReader();
    }

    public void startConsoleReader() throws IOException {

        new Thread(new Runnable() {

            @Override
            public void run() {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String line;
                try {
                    line = bufferedReader.readLine();
                    while(true) {
                        if(line != null) {
                            commandManager.runCommand(bufferedReader.readLine());
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }).start();

    }

    public void sendMessage(String message) {

        System.out.println("IMP: " + message);
        lastConsoleMessage = message;

    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getLastConsoleMessage() {
        return lastConsoleMessage;
    }
}
