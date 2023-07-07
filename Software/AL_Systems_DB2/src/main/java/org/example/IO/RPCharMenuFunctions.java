package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Armour;
import org.example.Entitys.Player;
import org.example.Entitys.RPChar;
import org.example.Entitys.Weapon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
        for(int i = 0; i < armours.length; i++){
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
                        armours[i] = GearMenuFunctions.selectArmour();
                        if(armours[i] == null){
                            System.out.println("Die gewählte Rüstung gibt es "
                                               + "nicht.");
                            repeatArmourSelect = true;
                        }
                        repeatArmourSelect = false;
                        break;
                    case 2:
                        //TODO armourErstellen
                        repeatArmourSelect = false;
                        break;
                    case 3:
                        armours[i] = null;
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
                    Weapon weapon = GearMenuFunctions.selectWeapon();
                    if(weapon != null){
                        weaponList.add(weapon);
                    }else{
                        System.out.println("Die gewählte Waffe gibt es nicht.");
                    }
                    repeatWeaponSelect = true;
                    break;
                case 2:
                    //TODO addWeapon()
                    repeatWeaponSelect = true;
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
        System.out.println("Charakter löschen:");
        RPChar rpChar = selectRPChar();
        if(rpChar == null){
            System.out.println("Der Charakter wurde nicht geunden");
            return;
        }
        if(rpChar.getPlayer() != null){
            System.out.println("Sie können den Charakter nicht löschen, da "
                               + "hängt noch ein Spieler dran.\n"
                               + "Entfernen Sie den Spieler und versuchen es "
                               + "dann erneut.");
            return;
        }
        if(!rpChar.getWeapons().isEmpty()){
            System.out.println("Sie können den Charakter nicht löschen, da "
                               + "hängen noch Waffen dran.\n"
                               + "Entfernen Sie die Waffen und versuchen Sie "
                               + "es dann noch einmal.");
            return;
        }
        boolean hasArmour = false;
        for (Armour armour : rpChar.getArmours()) {
            hasArmour =  armour != null ? true : hasArmour;
        }
        if(hasArmour){
            System.out.println("Sie können den Charakter nicht löschen, da "
                               + "hängen noch Rüstungen dran.\n"
                               + "Entfernen Sie die Rüstungen und versuchen "
                               + "Sie es dann noch einmal.");
            return;
        }
        System.out.println("Sicher, dass Sie folgenden Charakter löschen "
                           + "möchten? "
                           + "(J/N)");
        System.out.println(rpChar);
        sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        switch (input){
            case "j":
                try {
                    DBManager.deleteEntry(rpChar);
                    System.out.println("Der Charakter wurde gelöscht");
                }catch (Exception e){
                    System.out.println("Ups, da hat was nicht funktioniert");
                    e.printStackTrace();
                }
                break;
            case "n":
                System.out.println("Der Charakter wird nicht gelöscht.");
                break;
            default:
                System.out.println("Die Eingabe konnte nicht verarbeitet "
                                   + "werden.");
                break;
        }
    }

    public static void updateRPChar(){
        System.out.println("Charakter ändern:");
        RPChar rpChar = selectRPChar();
        if(rpChar == null){
            System.out.println("Der Charakter konnte nich gefunden werden.");
            return;
        }
        RPChar charUpdate = rpChar;
        boolean repeatChange = true;
        sc = new Scanner(System.in);
        while (repeatChange){
            System.out.println(charUpdate);
            System.out.println("Was möchten Sie ändern?\n"
                               + "Name [1]\n"
                               + "Titel [2]\n"
                               + "PvP [3]\n"
                               + "Spieler [4]\n"
                               + "Rüstungen [5]\n"
                               + "Waffen [6]\n"
                               + "Zurück [7]");
            int selected = 0;
            try {
                selected = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein.");
                repeatChange = true;
            }
            switch (selected){
                case 1:
                    System.out.println("Bitte geben Sie einen Namen ein:");
                    String charName = sc.nextLine();
                    charUpdate.setName(charName);
                    repeatChange = true;
                    break;
                case 2:
                    System.out.println("Bitte geben Sie einen Titel ein:");
                    String charTitel = sc.nextLine();
                    charUpdate.setTitle(charTitel);
                    repeatChange = true;
                    break;
                case 3:
                    boolean repeatSelectPvP = true;
                    int pvpInput = 0;
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
                                charUpdate.setPvp(true);
                                repeatSelectPvP = false;
                                break;
                            case 2:
                                charUpdate.setPvp(false);
                                repeatSelectPvP = false;
                                break;
                            default:
                                System.out.println("Bitte geben Sie eine passende Zahl "
                                                   + "ein.");
                                repeatSelectPvP = true;
                        }
                    }
                    repeatChange = true;
                    break;
                case 4:
                    boolean repeatSetPlayer = true;
                    int playerChoice = 0;
                    Player player = null;
                    while(repeatSetPlayer){
                        System.out.println("Bitte wählen Sie eine der folgenden "
                                           + "Möglichkeiten:\n"
                                           + "Bestehenden Spieler nutzen [1]\n"
                                           + "Neuen Spieler erstellen [2]\n"
                                           + "Abbrechen (Beendet Bearbeitung "
                                           + "des Charakters) [3]");
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
                                RPChar checkChar =
                                        DBManager.loadRPCharOfPlayer(player.getUuid());
                                if(checkChar != null){
                                    System.out.println("Der Spieler hat schon einen "
                                                       + "Charakter hinterlegt.\n"
                                                       + "Löschen Sie die Beziehung oder "
                                                       + "wählen Sie einen anderen "
                                                       + "Spieler.");
                                    continue;
                                }
                                charUpdate.setPlayer(player);
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
                    repeatChange = true;
                    break;
                case 5:
                    Armour[] armours = charUpdate.getArmours();
                    for(int i = 0; i < armours.length; i++){
                        boolean repeatArmourSelect = true;
                        System.out.println("Aktuelle Rüstung: " + armours[i]);
                        while (repeatArmourSelect){
                            System.out.println("Bitte wählen Sie eine der folgenden "
                                               + "Mögichkeiten:\n"
                                               + "Bestehende Rüstung nutzen [1]\n"
                                               + "Neue Rüstung erstellen [2]\n"
                                               + "Slot leer lassen [3]\n"
                                               + "Slot so lassen [4]");
                            int armourChoice = 0;
                            try {
                                armourChoice = Integer.parseInt(sc.nextLine());
                            }catch (NumberFormatException e){
                                System.out.println("Bitte geben Sie eine Zahl ein.");
                                repeatArmourSelect = true;
                            }
                            switch (armourChoice){
                                case 1:
                                    armours[i] = GearMenuFunctions.selectArmour();
                                    if(armours[i] == null){
                                        System.out.println("Die gewählte Rüstung gibt es "
                                                           + "nicht.");
                                        repeatArmourSelect = true;
                                    }
                                    repeatArmourSelect = false;
                                    break;
                                case 2:
                                    //TODO armourErstellen
                                    repeatArmourSelect = false;
                                    break;
                                case 3:
                                    armours[i] = null;
                                    System.out.println("Slot leer gelassen.");
                                    repeatArmourSelect = false;
                                    break;
                                case 4:
                                    System.out.println("Slot so gelassen");
                                    repeatArmourSelect = false;
                                    break;
                                default:
                                    System.out.println("Bitte geben Sie eine passende "
                                                       + "Zahl ein.");
                                    repeatArmourSelect = true;
                            }
                        }
                    }
                    repeatChange = true;
                    break;
                case 6:
                    boolean repeatWeaponChange = true;
                    while(repeatWeaponChange){
                        System.out.println("Wählen Sie eine der "
                                           + "Möglichkeiten:\n"
                                           + "Waffe löschen [1]\n"
                                           + "Waffe hinzufügen [2]\n"
                                           + "Zurück [3]");
                        int choice = 0;
                        try{
                            choice = Integer.parseInt(sc.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Bitte geben Sie eine Zahl "
                                               + "ein.");
                            repeatWeaponChange = true;
                        }
                        switch (choice){
                            case 1:
                                List<Weapon> weaponList =
                                        charUpdate.getWeapons();
                                System.out.println("Welche Waffe möchten Sie "
                                                   + "löschen? (Index "
                                                   + "eingeben)");
                                weaponList.forEach(weapon -> System.out.println(weapon.forSelect() + " Index " + weaponList.indexOf(weapon)));
                                int auswahl = 0;
                                try {
                                    auswahl = Integer.parseInt(sc.nextLine());
                                }catch (NumberFormatException e){
                                    System.out.println("Bitte geben Sie eine "
                                                       + "Zahl ein.");
                                }
                                weaponList.remove(auswahl);
                                break;
                            case 2:
                                Weapon weapon =
                                        GearMenuFunctions.selectWeapon();
                                if(weapon == null){
                                    System.out.println("Die Waffe konnte "
                                                       + "nicht gefunden "
                                                       + "werden.");
                                }
                                charUpdate.getWeapons().add(weapon);
                                repeatWeaponChange = true;
                                break;
                            case 3:
                                repeatWeaponChange = false;
                                break;
                            default:
                                System.out.println("Bitte geben Sie eine "
                                                   + "passende Zahl ein.");
                                repeatWeaponChange = true;
                        }
                    }
                    repeatChange = true;
                    break;
                case 7:
                    repeatChange = false;
                    break;
                default:
                    repeatChange = true;
                    break;
            }
        }
    }
}
