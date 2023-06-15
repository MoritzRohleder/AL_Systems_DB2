package org.example;

import org.example.Data.InitialSpecialBuildData;
import org.example.Data.InitialFactionData;
import org.example.Entitys.Faction;
import org.example.Entitys.SpecialBuild;
import org.example.IO.MainMenu;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Faction> factions = InitialFactionData.initializeFactions();
        Set<SpecialBuild> specialBuilds = InitialSpecialBuildData.initialiseSpecialBuilds();
        MainMenu.run();
    }
}