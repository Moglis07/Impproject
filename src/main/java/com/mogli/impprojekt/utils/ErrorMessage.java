package com.mogli.impprojekt.utils;

public class ErrorMessage {
    public Object printError(Object c) {
        System.out.println("[ERROR] there is a system error in " + c.getClass().getName() + " please send a Message to the Creator if you are not able to fix the Problem");
        return null;
    }
}
