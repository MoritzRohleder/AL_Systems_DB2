package org.example;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Faction;
import org.example.Enums.Alignment;
import org.example.Data.InitialFactionData;
import org.example.IO.MainMenu;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DBManager.persistFaction(new Faction("Rivendell", "2x healing speed. Can build athelas farms. The farms provide 12 athelas per month. Must show some athelas in the farm build.", "#49688b", Alignment.HIGH_ELF));

        Set<Faction> factions = InitialFactionData.initializeFactions(); 
        MainMenu.run();
    }
}