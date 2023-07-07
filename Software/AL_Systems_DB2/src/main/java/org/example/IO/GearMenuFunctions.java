package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Armour;
import org.example.Entitys.Weapon;

import java.util.List;
import java.util.Scanner;

public class GearMenuFunctions {

    private static Scanner sc;

    public static Armour selectArmour(){
        System.out.println("Rüstungs Auswahl:");
        List<Armour> armourList = DBManager.loadArmourFullTable();
        armourList.forEach(armour -> System.out.println(armour.forSelect()));
        System.out.println("Bitte wählen Sie eine der Rüstungen (ID eingeben)");
        sc = new Scanner(System.in);
        int selected;
        boolean repeatInput = true;
        while(repeatInput){
            try{
                selected = Integer.parseInt(sc.nextLine());
                return DBManager.loadArmourByID(selected);
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein.");
                repeatInput = true;
            }
        }
        return null;
    }

    public static Weapon selectWeapon(){
        System.out.println("Waffen Auswahl:");
        List<Weapon> weaponList = DBManager.loadWeaponFullTable();
        weaponList.forEach(weapon -> System.out.println(weapon.forSelect()));
        System.out.println("Bitte wählen Sie eine der Waffen (ID eingeben)");
        sc = new Scanner(System.in);
        int selected;
        boolean repeatInput = true;
        while(repeatInput){
            try{
                selected = Integer.parseInt(sc.nextLine());
                return DBManager.loadWeaponByID(selected);
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein.");
                repeatInput = true;
            }
        }
        return null;
    }
}
