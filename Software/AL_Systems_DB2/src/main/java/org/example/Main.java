package org.example;

import org.example.DBConntection.DBManager;
import org.example.Data.*;
import org.example.Data.InitialFactionData;
import org.example.Entitys.*;
import org.example.Enums.Alignment;
import org.example.IO.MainMenu;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Initial Daten zu Völkern und Ausrüstung
        List<Faction> factions = InitPresentation.generateFactions();
        factions.forEach(faction -> DBManager.persistFaction(faction));

        List<Armour> armours = InitPresentation.generateArmours();
        armours.forEach(armour -> DBManager.persistArmour(armour));

        List<Weapon> weapons = InitPresentation.generateWeapons();
        weapons.forEach(weapon -> DBManager.persistWeapon(weapon));

        //Ein Beispiel Spieler
        Player anedhel = new Player("ae7219bf-4e44-4bc4-b7fc-3c74e95786f0", "Anedhel", "anedhel");
        anedhel.joinFaction(DBManager.loadFactionByName("Gondor"));
        DBManager.persistPlayer(anedhel);

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
        DBManager.persistRPChar(aulendur);

        //MainMenu.run();

        Faction fac = DBManager.loadFactionByName("Gondor");
        System.out.println(fac.toString());

        Player p1 = DBManager.loadPlayerByIGN("Anedhel");
        System.out.println(p1.toString());

        DBManager.deleteEntry(aulendur);
        DBManager.deleteEntry(anedhel);

        Player p2 = DBManager.loadPlayerByDiscordID("anedhel");
        System.out.println(p2.toString());

        RPChar rpc = DBManager.loadRPCharByName("Aulendur");
        System.out.println(rpc.toString());
    }
}