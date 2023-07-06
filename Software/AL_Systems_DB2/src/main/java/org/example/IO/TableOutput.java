package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.*;
import org.example.Enums.Tables;

import java.util.LinkedList;
import java.util.List;

public class TableOutput {

    public static void outputTable(Tables table){
        switch(table){
            case Player:
                List<Player> playerList = DBManager.loadPlayerFullTable();
                playerList.forEach(player -> System.out.println(player));
                break;
            case RPChar:
                List<RPChar> rpCharList = DBManager.loadRPCharFullTable();
                rpCharList.forEach(rpChar -> System.out.println(rpChar));
                break;
            case Gear:
                List<Gear> gearList = new LinkedList<>();
                gearList.addAll(DBManager.loadArmourFullTable());
                gearList.addAll(DBManager.loadWeaponFullTable());
                gearList.forEach(gear -> System.out.println(gear));
                break;
            case Armour:
                List<Armour> armourList = DBManager.loadArmourFullTable();
                armourList.forEach(armour -> System.out.println(armour));
                break;
            case Weapon:
                List<Weapon> weaponList = DBManager.loadWeaponFullTable();
                weaponList.forEach(weapon -> System.out.println(weapon));
                break;
            case Faction:
                List<Faction> factionList = DBManager.loadFactionFullTable();
                factionList.forEach(faction -> System.out.println(faction));
                break;
            default:
                break;
        }
    }
}
