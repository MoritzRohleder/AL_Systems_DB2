package org.example;

import org.example.DBConntection.DBManager;
import org.example.Data.InitialFactionData;
import org.example.Data.InitialProdSiteData;
import org.example.Data.InitialSpecialBuildData;
import org.example.Data.InitialFactionData;
import org.example.Entitys.Faction;
import org.example.Entitys.ProdSite;
import org.example.Entitys.SpecialBuild;
import org.example.IO.MainMenu;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DBManager.persistFaction(new Faction("Rivendell", "2x healing speed. Can build athelas farms. The farms provide 12 athelas per month. Must show some athelas in the farm build.", "#49688b", Alignment.HIGH_ELF));

        Set<Faction> factions = InitialFactionData.initializeFactions(); 
        Set<SpecialBuild> specialBuilds = InitialSpecialBuildData.initialiseSpecialBuilds();
        Set<ProdSite> productionSites = InitialProdSiteData.initialiseProdSites();
        MainMenu.run();
    }
}