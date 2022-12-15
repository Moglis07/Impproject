package com.mogli.impprojekt.commands;

import com.mogli.impprojekt.CommandsUsage;
import com.mogli.impprojekt.Main;

import java.io.IOException;

public class HelpCMD implements Command {
    @Override
    public void onCommand(String[] args) throws IOException {

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("  .oooooo.                                                                             .o8       oooo   o8o               .   ");
        System.out.println(" d8P'  `Y8b                                                                           \"888       `888   `\"'             .o8   ");
        System.out.println("888           .ooooo.  ooo. .oo.  .oo.   ooo. .oo.  .oo.    .oooo.   ooo. .oo.    .oooo888        888  oooo   .oooo.o .o888oo");
        System.out.println("888          d88' `88b `888P\"Y88bP\"Y88b  `888P\"Y88bP\"Y88b  `P  )88b  `888P\"Y88b  d88' `888        888  `888  d88(  \"8   888   ");
        System.out.println("888          888   888  888   888   888   888   888   888   .oP\"888   888   888  888   888        888   888  `\"Y88b.    888   ");
        System.out.println("`88b    ooo  888   888  888   888   888   888   888   888  d8(  888   888   888  888   888        888   888  o.  )88b   888 . ");
        System.out.println(" `Y8bood8P'  `Y8bod8P' o888o o888o o888o o888o o888o o888o `Y888\"\"8o o888o o888o `Y8bod88P\"      o888o o888o 8\"\"888P'   \"888\" ");
        System.out.println(" ");

        Main.getCommandManager().getCommands().forEach((key, value)->{
            System.out.println(Main.getConfigManager().get("prefix") + key + " × " + CommandsUsage.exit);
        });
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

    }
}
