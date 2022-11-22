package com.mogli.impprojekt;

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
        commandManager = new CommandManager();
        System.out.println("IMPSTART: consolemanager.java loaded");
        startConsoleReader();

    }

    public void startConsoleReader() throws IOException {
        new Thread(new Runnable() {

            @Override
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String line;
                try {
                    while((line = bufferedReader.readLine()) != null && !line.equals("stopdestroy")) {
                        System.out.println(bufferedReader.readLine());
                        if(bufferedReader.readLine() != null) {
                            System.out.println(bufferedReader.readLine());
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
