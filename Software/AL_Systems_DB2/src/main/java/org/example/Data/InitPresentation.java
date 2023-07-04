package org.example.Data;

import org.example.Entitys.*;

import java.util.HashSet;
import java.util.Set;

public class InitPresentation {
    public static Set<Faction> generateFactions(){
        Set<Faction> factions = new HashSet<>();

        return factions;
    }

    public static Set<Weapon> generateWeapons(){
        Set<Weapon> weapons = new HashSet<>();

        Weapon ironSword = new Weapon("Iron Sword", 251, "Sword", 7);
        return weapons;
    }

    public static Set<Armour> generateArmours(){
        Set<Armour> armours = new HashSet<>();

        Armour ironHelmet = new Armour("Iron Helmet", 165, "Helmet", 2.0);

        Armour goldHelmet = new Armour("Gold Helmet", 77, "Helmet", 2.0);

        Armour diamondHelmet = new Armour("Diamond Helmet", 363, "Helmet", 3.0);

        Armour ironChestplate = new Armour("Iron Chestplate", 240, "Chestplate", 6.0);

        Armour goldChestplate = new Armour("Gold Chestplate", 112, "Chestplate", 5.0);

        Armour diamondChestplate = new Armour("Diamond Chestplate", 528, "Chestplate", 8.0);

        Armour ironLeggings = new Armour("Iron Leggings", 225, "Leggins", 5);

        Armour goldLeggings = new Armour("Gold Leggings", 105, "Leggings", 3);

        Armour diamondLeggings = new Armour("Diamond Leggings", 495, "Leggings", 6);

        Armour ironBoots = new Armour("Iron Boots", 195, "Boots", 2);

        Armour goldBoots = new Armour("Gold Boots", 91, "Boots", 1);

        Armour diamondBoots = new Armour("Diamond Boots", 429, "Boots", 3);

        return armours;
    }
}
