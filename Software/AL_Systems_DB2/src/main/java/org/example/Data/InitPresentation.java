package org.example.Data;

import org.example.Entitys.*;
import org.example.Enums.Alignment;

import java.util.LinkedList;
import java.util.List;

public class InitPresentation {
    public static List<Faction> generateFactions(){
        List<Faction> factions = new LinkedList<>();

        Faction gondor = new Faction("Gondor", "Gondor Buff", "White", Alignment.GONDOR);
        factions.add(gondor);

        Faction mordor = new Faction("Mordor", "Mordor Buff", "Red", Alignment.MORDOR);
        factions.add(mordor);

        Faction rohan = new Faction("Rohan", "Rohan Buff", "Green", Alignment.ROHAN);
        factions.add(rohan);

        Faction isengard = new Faction("Isenagrd", "Isengard Buff", "Dark Grey", Alignment.URUK_HAI);
        factions.add(isengard);

        Faction lothlorien = new Faction("Lothlórien", "Lothlorien Buff", "Yellow", Alignment.GALADHRIM);
        factions.add(lothlorien);

        Faction dolGuldur = new Faction("Dol Guldur", "Dol Guldur Buff", "Purple", Alignment.DOL_GULDUR);
        factions.add(dolGuldur);
        return factions;
    }

    public static List<Weapon> generateWeapons(){
        List<Weapon> weapons = new LinkedList<>();

        Weapon ironSword = new Weapon("Iron Sword", 251, "Sword", 7.0);
        weapons.add(ironSword);

        Weapon goldSword = new Weapon("Gold Sword", 10, "Sword", 5.0);
        weapons.add(goldSword);

        Weapon diamondSword = new Weapon("Diamond Sword", 300, "Sword", 8.0);
        weapons.add(diamondSword);

        return weapons;
    }

    public static List<Armour> generateArmours(){
        List<Armour> armours = new LinkedList<>();

        Armour ironHelmet = new Armour("Iron Helmet", 165, "Helmet", 2.0);
        armours.add(ironHelmet);

        Armour goldHelmet = new Armour("Gold Helmet", 77, "Helmet", 2.0);
        armours.add(goldHelmet);

        Armour diamondHelmet = new Armour("Diamond Helmet", 363, "Helmet", 3.0);
        armours.add(diamondHelmet);

        Armour ironChestplate = new Armour("Iron Chestplate", 240, "Chestplate", 6.0);
        armours.add(ironChestplate);

        Armour goldChestplate = new Armour("Gold Chestplate", 112, "Chestplate", 5.0);
        armours.add(goldChestplate);

        Armour diamondChestplate = new Armour("Diamond Chestplate", 528, "Chestplate", 8.0);
        armours.add(diamondChestplate);

        Armour ironLeggings = new Armour("Iron Leggings", 225, "Leggins", 5);
        armours.add(ironLeggings);

        Armour goldLeggings = new Armour("Gold Leggings", 105, "Leggings", 3);
        armours.add(goldLeggings);

        Armour diamondLeggings = new Armour("Diamond Leggings", 495, "Leggings", 6);
        armours.add(diamondLeggings);

        Armour ironBoots = new Armour("Iron Boots", 195, "Boots", 2);
        armours.add(ironBoots);

        Armour goldBoots = new Armour("Gold Boots", 91, "Boots", 1);
        armours.add(goldBoots);

        Armour diamondBoots = new Armour("Diamond Boots", 429, "Boots", 3);
        armours.add(diamondBoots);

        return armours;
    }
}
