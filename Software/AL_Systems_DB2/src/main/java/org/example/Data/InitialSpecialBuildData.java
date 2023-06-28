package org.example.Data;

import org.example.Entitys.SpecialBuild;

import java.util.HashSet;
import java.util.Set;

public class InitialSpecialBuildData {

    public static Set<SpecialBuild> initialiseSpecialBuilds(){
        Set<SpecialBuild> specialBuilds = new HashSet<>();

        SpecialBuild bank = new SpecialBuild("Bank","Provides the claimbuild with means to exchange coins. Provides 500 coins monthly");
        specialBuilds.add(bank);

        SpecialBuild harbour = new SpecialBuild("Harbour", "Allows movement onto sea regions or up and down rivers.");
        specialBuilds.add(harbour);

        SpecialBuild houseOfHealing = new SpecialBuild("House of Healing", "Allows armies and characters to heal at this build.");
        specialBuilds.add(houseOfHealing);

        SpecialBuild embassy = new SpecialBuild("Embassy", "Allows for a trading camp to be build at this claimbuild, enabling weapon trading between factions once allied. Allows for alliance to be formed. Allows for an allied faction to use a house of healing in the same build.");
        specialBuilds.add(embassy);

        SpecialBuild shop = new SpecialBuild("Shop", "Provides a trader of the relevent shop type.");
        specialBuilds.add(shop);

        return specialBuilds;
    }
}
