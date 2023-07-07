package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Armour;
import org.example.Entitys.Player;
import org.example.Entitys.RPChar;
import org.example.Entitys.Weapon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;

public class RPCharMenuFunctions {

    private static Scanner sc;

    public static RPChar selectRPChar(){
        System.out.println("Charakter Auswahl:");
        List<RPChar> charList = DBManager.loadRPCharFullTable();
        charList.forEach(character -> System.out.println(character.forSelect()));
        System.out.println("Bitte wählen Sie einen der Charaktere aus "
                           + "(ID eingeben)");
        sc = new Scanner(System.in);
        int selected;
        boolean repeatInput = true;
        while(repeatInput){
            try{
                selected = Integer.parseInt(sc.nextLine());
                return DBManager.loadRPCharByID(selected);
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein.");
                repeatInput = true;
            }
        }
        return null;
    }

    public static void addRPChar(){
        System.out.println("Charakter hinzufügen:");
        sc = new Scanner(System.in);
        RPChar newChar;
        System.out.println("Bitte geben Sie einen Namen für den Charakter "
                           + "ein:");
        String charName = sc.nextLine();
        System.out.println("Bitte geben Sie einen Tiel für den Charakter ein:");
        String charTitle = sc.nextLine();
        //PvP Auswählen
        int pvpInput = 0;
        boolean pvp = false;
        boolean repeatSelectPvP = true;
        while(repeatSelectPvP){
            try {
                System.out.println("Bitte geben Sie an, ob der Charakter PvP oder PvE"
                                   + " nutzt:"
                                   + "PvP [1]"
                                   + "PvE [2]");
                pvpInput = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein:");
                repeatSelectPvP = true;
            }
            switch(pvpInput){
                case 1:
                    pvp = true;
                    repeatSelectPvP = false;
                    break;
                case 2:
                    pvp = false;
                    repeatSelectPvP = false;
                    break;
                default:
                    System.out.println("Bitte geben Sie eine passende Zahl "
                                       + "ein.");
                    repeatSelectPvP = true;
            }
        }
        //Spieler auswählen
        boolean repeatSetPlayer = true;
        int playerChoice = 0;
        Player player = null;
        while(repeatSetPlayer){
            System.out.println("Bitte wählen Sie eine der folgenden "
                               + "Möglichkeiten:\n"
                               + "Bestehenden Spieler nutzen [1]\n"
                               + "Neuen Spieler erstellen [2]\n"
                               + "Abbrechen (Beendet Erstellung des "
                               + "Charakters) [3]");
            try {
                playerChoice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein");
                repeatSetPlayer = true;
            }
            switch(playerChoice){
                case 1:
                    System.out.println("Bitte wählen Sie den Spieler, den Sie"
                                       + " nutzen möchten:");
                    player = PlayerMenuFunctions.selectPlayer();
                    RPChar rpChar =
                            DBManager.loadRPCharOfPlayer(player.getUuid());
                    if(rpChar != null){
                        System.out.println("Der Spieler hat schon einen "
                                           + "Charakter hinterlegt.\n"
                                           + "Löschen Sie die Beziehung oder "
                                           + "wählen Sie einen anderen "
                                           + "Spieler.");
                        continue;
                    }
                    repeatSetPlayer = false;
                    break;
                case 2:
                    //TODO PlayerMenuFunctions addPlayer()
                    repeatSetPlayer = false;
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Bitte geben Sie eine passende Zahl "
                                       + "ein.");
                    repeatSetPlayer = true;
            }
        }
        //Rüstung auswählen
        Armour[] armours = new Armour[8];
        for (Armour armour : armours) {
            boolean repeatArmourSelect = true;
            while (repeatArmourSelect){
                System.out.println("Bitte wählen Sie eine der folgenden "
                                   + "Mögichkeiten:\n"
                                   + "Bestehende Rüstung nutzen [1]\n"
                                   + "Neue Rüstung erstellen [2]\n"
                                   + "Slot leer lassen [3]");
                int armourChoice = 0;
                try {
                    armourChoice = Integer.parseInt(sc.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Bitte geben Sie eine Zahl ein.");
                    repeatArmourSelect = true;
                }
                switch (armourChoice){
                    case 1:
                        //TODO selectAmourFunction
                        repeatArmourSelect = false;
                        break;
                    case 2:
                        //TODO armourErstellen
                        repeatArmourSelect = false;
                        break;
                    case 3:
                        armour = null;
                        System.out.println("Slot leer gelassen.");
                        repeatArmourSelect = false;
                        break;
                    default:
                        System.out.println("Bitte geben Sie eine passende "
                                           + "Zahl ein.");
                        repeatArmourSelect = true;
                }
            }
        }
        //Waffen auswählen
        List<Weapon> weaponList = new LinkedList<>();
        boolean repeatWeaponSelect = true;
        while(repeatWeaponSelect){
            System.out.println("Bitte wählen Sie eine der folgenden "
                               + "Möglichkeiten\n"
                               + "Bestehende Waffe nutzen [1]\n"
                               + "Neue Waffe benutzen [2]\n"
                               + "Keine Waffe mehr hinzufügen [3]");
            int weaponChoice = 0;
            try {
                weaponChoice = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein.");
                repeatWeaponSelect = true;
            }
            switch (weaponChoice){
                case 1:
                    //TODO weaponSelect()
                    break;
                case 2:
                    //TODO addWeapon()
                    break;
                case 3:
                    System.out.println("Waffen auswahl beendet.");
                    repeatWeaponSelect = false;
                    break;
                default:
                    System.out.println("Bitte geben Sie eine passende Zahl "
                                       + "ein.");
                    repeatWeaponSelect = true;
            }
        }

        newChar = new RPChar(player, charName, charTitle,pvp);
        newChar.setArmours(armours);
        newChar.setWeapons(weaponList);

        try{
            DBManager.persist(newChar);
            System.out.println("Erfolgreich hinzugefügt wurde \n" + newChar.toString());
        }catch (Exception e){
            System.out.println("Ups da hat was nicht funktioniert.");
            e.printStackTrace();
        }
    }

    public static void deleteRPChar(){

    }

    public static void updateRPChar(){

    }
}
