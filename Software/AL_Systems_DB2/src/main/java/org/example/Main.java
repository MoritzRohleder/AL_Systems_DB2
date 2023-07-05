package org.example;

import org.example.DBConntection.DBManager;
import org.example.Data.*;
import org.example.Entitys.*;
import org.example.IO.MainMenu;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Initial Daten zu Völkern und Ausrüstung
        List<Faction> factions = InitPresentation.generateFactions();
        factions.forEach(faction -> DBManager.persist(faction));

        List<Armour> armours = InitPresentation.generateArmours();
        armours.forEach(armour -> DBManager.persist(armour));

        List<Weapon> weapons = InitPresentation.generateWeapons();
        weapons.forEach(weapon -> DBManager.persist(weapon));

        //Ein Beispiel Spieler
        Player anedhel = new Player("ae7219bf-4e44-4bc4-b7fc-3c74e95786f0", "Anedhel", "anedhel");
        anedhel.joinFaction(DBManager.loadFactionByName("Gondor"));
        DBManager.persist(anedhel);

        //Ein Beispiel Roleplay Character
        RPChar aulendur = new RPChar(anedhel, "Aulendur", "Smith of Gondor", true);
        Armour[] armours1 = new Armour[8];
        armours1[0] = DBManager.loadArmourByName("Iron Helmet");
        armours1[1] = DBManager.loadArmourByName("Iron Chestplate");
        armours1[2] = DBManager.loadArmourByName("Iron Leggings");
        armours1[3] = DBManager.loadArmourByName("Iron Boots");
        armours1[4] = DBManager.loadArmourByName("Diamond Helmet");
        armours1[5] = DBManager.loadArmourByName("Diamond Chestplate");
        armours1[6] = DBManager.loadArmourByName("Diamond Leggings");
        armours1[7] = DBManager.loadArmourByName("Diamond Boots");
        aulendur.setArmours(armours1);
        LinkedList<Weapon> weapons1 = new LinkedList<>();
        weapons1.add(DBManager.loadWeaponByName("Iron Sword"));
        weapons1.add(DBManager.loadWeaponByName("Diamond Sword"));
        aulendur.setWeapons(weapons1);
        DBManager.persist(aulendur);

        //MainMenu.run();

        Faction fac1 = DBManager.loadFactionByName("Gondor");
        System.out.println(fac1);

        Faction gondor = DBManager.loadFactionByName("Gondor");
        RPChar aulendur1 = DBManager.loadRPCharByName("Aulendur");
        gondor.setFactionLeader(aulendur1);
        DBManager.update(gondor);

        Faction fac2 = DBManager.loadFactionByName("Gondor");
        System.out.println(fac2);

        Player p1 = DBManager.loadPlayerByIGN("Anedhel");
        System.out.println(p1);

        Player p2 = DBManager.loadPlayerByDiscordID("anedhel");
        System.out.println(p2);

        Faction fac3 = DBManager.loadFactionByName("Gondor");
        fac3.setFactionLeader(null);
        DBManager.update(fac3);
        RPChar rpc = DBManager.loadRPCharByName("Aulendur");
        System.out.println(rpc);

        Weapon w = DBManager.loadWeaponByName("Iron Sword");
        System.out.println(w);

        Armour a = DBManager.loadArmourByName("Iron Helmet");
        System.out.println(a);
    }
}