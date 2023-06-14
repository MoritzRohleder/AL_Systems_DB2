package org.example;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Faction;
import org.example.Enums.Alignment;
import org.example.IO.MainMenu;

public class Main {
    public static void main(String[] args) {
        //MainMenu.run();
        DBManager.persistFaction(new Faction("Rivendell", "2x healing speed. Can build athelas farms. The farms provide 12 athelas per month. Must show some athelas in the farm build.", "#49688b", Alignment.HIGH_ELF));
    }
}