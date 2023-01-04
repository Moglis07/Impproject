package com.mogli.impprojekt.commands.huffman;

import com.mogli.impprojekt.commands.Command;

import java.io.IOException;

public class HufmanCMD implements Command {
    @Override
    public void onCommand(String[] args) throws IOException, ClassNotFoundException {

        Huffman.compress(args[0]);
        System.out.println(Huffman.expand());

    }
}
