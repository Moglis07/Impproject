package com.mogli.impprojekt.commands;

public class test implements Command{

    @Override
    public boolean onCommand(String[] args) {

        System.out.println(args);
        System.out.println("test1");

        return false;
    }
}
