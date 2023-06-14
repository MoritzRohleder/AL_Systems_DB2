package org.example;

import org.example.Data.InitialFactionData;
import org.example.Entitys.Faction;
import org.example.IO.MainMenu;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Faction> factions = InitialFactionData.initializeFactions();
        MainMenu.run();
    }
}