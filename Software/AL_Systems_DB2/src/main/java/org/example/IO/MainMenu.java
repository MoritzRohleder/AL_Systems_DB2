package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Armour;
import org.example.Entitys.Player;
import org.example.Enums.Menues;
import org.example.Enums.Tables;

import java.util.Scanner;

public class MainMenu {

    private static Scanner sc;

    /**
     * Die Methode run() ruft so lange die mainMenu() Funktion auf, bis diese false zurück gibt.
     */
    public static void run(Menues menu){
        boolean repeat = true;
        switch(menu){
            case mainMenu:
                while(repeat){
                    repeat = mainMenu();
                }
                break;
            case gearMenu:
                while(repeat){
                    repeat = gearMenu();
                }
                break;
            case armourMenu:
                while (repeat){
                    repeat = armourMenu();
                }
                break;
            case weaponMenu:
                while(repeat){
                    repeat = weaponMenu();
                }
                break;
            case facMenu:
                while (repeat){
                    repeat = facMenu();
                }
                break;
            case playerMenu:
                while (repeat){
                    repeat = playerMenu();
                }
                break;
            case rpCharMenu:
                while (repeat){
                    repeat = rpCharMenu();
                }
                break;
        }
    }

    /**
     * Das Hauptmenü der Konsolen Anwendung.
     * Hier wählt der Nutzer die Funktion aus, welche er ausführen möchte.
     *
     * @returns false wenn Beenden [6] ausgewählt wird, ansonsten true
     */
    private static boolean mainMenu(){
        System.out.println("HauptmenÜ:\n"
                           + "Bitte wählen Sie ein Untermenü aus:\n"
                           + "Ausrüstung [1]\n"
                           + "Völker [2]\n"
                           + "Spieler [3]\n"
                           + "Rollenspiel-Charakter [4]\n"
                           + "Beenden [5]");

        sc = new Scanner(System.in);
        int selected;
        try{
            selected = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Bitte geben Sie eine Zahl ein.");
            return true;
        }

        switch (selected){
            case 1:
                run(Menues.gearMenu);
                return true;
            case 2:
                run(Menues.facMenu);
                return true;
            case 3:
                run(Menues.playerMenu);
                return true;
            case 4:
                run(Menues.rpCharMenu);
                return true;
            case 5:
                System.out.println("Beenden ausgewählt");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }

    private static boolean gearMenu(){
        System.out.println("Ausrüstungs Menü:\n"
                           + "Bitte wählen Sie einen der foglenden Punkte "
                           + "aus:\n"
                           + "Alle Ausrüstung anzeigen [1]\n"
                           + "Ausrüstung nach Material anzeigen [2]\n"
                           + "Rüstungs Menü [3]\n"
                           + "Waffen Menü [4]\n"
                           + "Zurück [5]");

        sc = new Scanner(System.in);
        int selected;
        try{
            selected = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Bitte geben Sie eine Zahl ein.");
            return true;
        }

        switch(selected){
            case 1:
                TableOutput.outputTable(Tables.Gear);
                return true;
            case 2:
                GearMenuFunctions.selectGearByMaterial();
                return true;
            case 3:
                run(Menues.armourMenu);
                return true;
            case 4:
                run(Menues.weaponMenu);
                return true;
            case 5:
                System.out.println("Zurück zum Hauptmenü");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }

    private static boolean armourMenu(){
        System.out.println("Rüstungs Menü:\n"
                           + "Bitte wählen Sie einen der foglenden Punkte "
                           + "aus:\n"
                           + "Alle Rüstungen anzeigen [1]\n"
                           + "Rüstung nach ID suchen [2]\n"
                           + "Rüstung nach Name suchen [3]\n"
                           + "Rüstung nach Typ suchen [4]\n"
                           + "Rüstung nach Material suchen [5]\n"
                           + "Zurück [6]");

        sc = new Scanner(System.in);
        int selected;
        try{
            selected = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Bitte geben Sie eine Zahl ein.");
            return true;
        }

        switch(selected){
            case 1:
                TableOutput.outputTable(Tables.Armour);
                return true;
            case 2:
                System.out.println("Bitte ID angeben:");
                System.out.println(DBManager.loadArmourByID(Integer.parseInt(sc.nextLine())));
                return true;
            case 3:
                System.out.println("Bitte Name angeben:");
                System.out.println(DBManager.loadArmourByName(sc.nextLine()));
                return true;
            case 4:
                System.out.println("Bitte Typ angeben:");
                DBManager.loadArmoursByType(sc.nextLine()).forEach(armour -> System.out.println(armour));
                return true;
            case 5:
                System.out.println("Bitte Material angeben:");
                DBManager.loadArmoursByMaterial(sc.nextLine()).forEach(armour -> System.out.println(armour));
                return true;
            case 6:
                System.out.println("Zurück zum Hauptmenü");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }

    private static boolean weaponMenu(){
        System.out.println("Waffen Menü:\n"
                           + "Bitte wählen Sie einen der foglenden Punkte "
                           + "aus:\n"
                           + "Alle Waffen anzeigen [1]\n"
                           + "Waffe nach ID suchen [2]\n"
                           + "Waffe nach Name suchen [3]\n"
                           + "Waffen nach Typ suchen [4]\n"
                           + "Waffen nach Material suchen [5]\n"
                           + "Zurück [6]");

        sc = new Scanner(System.in);
        int selected;
        try{
            selected = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Bitte geben Sie eine Zahl ein.");
            return true;
        }

        switch(selected){
            case 1:
                TableOutput.outputTable(Tables.Weapon);
                return true;
            case 2:
                //Waffe nach ID suchen
                System.out.println("Bitte ID angeben:");
                System.out.println(DBManager.loadWeaponByID(Integer.parseInt(sc.nextLine())));
                return true;
            case 3:
                //Waffe nach Name suchen
                System.out.println("Bitte Name angeben:");
                System.out.println(DBManager.loadWeaponByName(sc.nextLine()));
                return true;
            case 4:
                //Waffen nach Typ suchen
                System.out.println("Bitte Typ angeben:");
                DBManager.loadWeaponsByType(sc.nextLine()).forEach(weapon -> System.out.println(weapon));
                return true;
            case 5:
                //Waffen nach Material suchen
                System.out.println("Bitte Material angeben:");
                DBManager.loadWeaponByMaterial(sc.nextLine()).forEach(weapon -> System.out.println(weapon));
                return true;
            case 6:
                System.out.println("Zurück zum Hauptmenü");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }

    private static boolean facMenu(){
        System.out.println("Völker Menü:\n"
                           + "Bitte wählen Sie einen der folgenden Punkte "
                           + "aus:\n"
                           + "Alle Völker anzeigen [1]\n"
                           + "Volk nach ID suchen [2]\n"
                           + "Volk nach Namen suchen [3]\n"
                           + "Anrührer eines Volks ausgeben [4]\n"
                           + "Mitglieder eines Volks ausgeben [5]\n"
                           + "Ein Volk hinzufügen [6]\n"
                           + "Ein Volk löschen [7]\n"
                           + "Ein Volk ändern [8]\n"
                           + "Zurück [9]");

        sc = new Scanner(System.in);
        int selected;
        try{
            selected = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Bitte geben Sie eine Zahl ein.");
            return true;
        }

        switch(selected){
            case 1:
                TableOutput.outputTable(Tables.Faction);
                return true;
            case 2:
                FactionMenuFunctions.searchFacByID();
                return true;
            case 3:
                FactionMenuFunctions.searchFacByName();
                return true;
            case 4:
                FactionMenuFunctions.getLeaderOfFac();
                return true;
            case 5:
                FactionMenuFunctions.getMembersOfFac();
                return true;
            case 6:
                FactionMenuFunctions.addFaction();
                return true;
            case 7:
                FactionMenuFunctions.deleteFaction();
                return true;
            case 8:
                FactionMenuFunctions.updateFaction();
                return true;
            case 9:
                System.out.println("Zurück zum Hauptmenü");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }

    private static boolean playerMenu(){
        System.out.println("Spieler Menü:\n"
                           + "Bitte wählen Sie einen der foglenden Punkte "
                           + "aus:\n"
                           + "Alle Spieler anzeigen [1]\n"
                           + "Spieler nach UUID suchen [2]\n"
                           + "Spieler nach IGN suchen [3]\n"
                           + "Spieler nach DiscordID suchen [4]\n"
                           + "Volk eines Spielers ausgeben [5]\n"
                           + "Rollenspiel-Charakter eines Spielers ausgeben "
                           + "[6]\n"
                           + "Spieler hinzufügen [7]\n"
                           + "Spieler ändern [8]\n"
                           + "Zurück [9]");

        sc = new Scanner(System.in);
        int selected;
        try{
            selected = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Bitte geben Sie eine Zahl ein.");
            return true;
        }

        switch(selected){
            case 1:
                TableOutput.outputTable(Tables.Player);
                return true;
            case 2:
                //Spieler nach UUID suchen
                System.out.println("Bitte UUID angeben: (ae7219bf-4e44-4bc4-b7fc-3c74e95786f0)" );
                System.out.println(DBManager.loadPlayerByUUID(sc.nextLine()));
                return true;
            case 3:
                //Spieler nach IGN suchen
                System.out.println("Bitte IGN angeben: (Anedhel)");
                System.out.println(DBManager.loadPlayerByIGN(sc.nextLine()));
                return true;
            case 4:
                //Spieler nach DiscordID suchen
                System.out.println("Bitte DiscordId angeben: (anedhel)");
                System.out.println(DBManager.loadPlayerByDiscordID(sc.nextLine()));
                return true;
            case 5:
                //Volk eines Spielers ausgeben
                //Spieler auswählen, dann Faction von diesem ausgeben
                System.out.println("Bitte IGN angeben: (Anedhel)");
                try {
                    System.out.println(DBManager.loadPlayerByIGN(sc.nextLine()).getFaction());
                }catch (Exception e){

                }
                return true;
            case 6:
                //Rollenspiel-Charakter eines Spielers ausgeben
                System.out.println("Bitte IGN angeben: (Anedhel)");
                try {
                    System.out.println(DBManager.loadPlayerByIGN(sc.nextLine()).getRpchar());
                }catch (Exception e){

                }
                return true;
            case 7:
                PlayerMenuFunctions.addPlayer();
                return true;
            case 8:
                PlayerMenuFunctions.updatePlayer();
                return true;
            case 9:
                System.out.println("Zurück zum Hauptmenü");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }

    private static boolean rpCharMenu(){
        System.out.println("Charakter Menü:\n"
                           + "Bitte wählen Sie einen der foglenden Punkte "
                           + "aus:\n"
                           + "Alle Charaktere anzeigen [1]\n"
                           + "Charaktere nach Spiel Präferenz ausgeben [2]\n"
                           + "Charakter nach ID suchen [3]\n"
                           + "Charakter nach Name suchen [4]\n"
                           + "Spieler eines Charakters ausgeben [5]\n"
                           + "Alle Rüstungen eines Charakters ausgeben [6]\n"
                           + "Alle Waffen eines Charakters ausgeben [7]\n"
                           + "Einen Charakter hinzufügen [8]\n"
                           + "Einen Charakter löschen [9]\n"
                           + "Einen Charakter bearbeiten [10]\n"
                           + "Zurück [11]");

        sc = new Scanner(System.in);
        int selected;
        try{
            selected = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Bitte geben Sie eine Zahl ein.");
            return true;
        }

        switch(selected){
            case 1:
                TableOutput.outputTable(Tables.RPChar);
                return true;
            case 2:
                //Charaktere nach Spiel Präferenz ausgeben
                System.out.println("PvP? (true oder false)");
                System.out.println(DBManager.loadRPCharsByPvP(sc.nextBoolean()));
                return true;
            case 3:
                //Charakter nach ID suchen
                System.out.println("ID angeben: " + DBManager.loadRPCharByID(Integer.parseInt(sc.nextLine())));
                return true;
            case 4:
                //Charakter nach Name suchen
                System.out.println("Name angeben: (Aulendur) ");
                System.out.println(DBManager.loadRPCharByName(sc.nextLine()));
                return true;
            case 5:
                //Spieler eines Charakters ausgeben
                //RPChar auswählen, dann einfach den Spieler von diesem ausgeben
                System.out.println("Name angeben: (Aulendur)");
                try {
                    System.out.println(DBManager.loadRPCharByName(sc.nextLine()).getPlayer());
                }catch (Exception e){

                }
                return true;
            case 6:
                //Alle Rüstungen eines Charakters
                //RPChar auswählen, dann einfach die Rüstungen von diesem ausgeben
                System.out.println("Name angeben: (Aulendur)");
                try {
                    for (Armour armour : DBManager.loadRPCharByName(sc.nextLine()).getArmours()) {
                        System.out.println(armour);
                    }
                }catch (Exception e){

                }
                return true;
            case 7:
                //Alle Waffen eines Charakters
                //RPChar auswählen, dann einfach die Waffen von diesem ausgeben
                System.out.println("Name angeben: ");
                DBManager.loadRPCharByName(sc.nextLine()).getWeapons().forEach(weapon -> System.out.println(weapon));
                return true;
            case 8:
                RPCharMenuFunctions.addRPChar();
                return true;
            case 9:
                RPCharMenuFunctions.deleteRPChar();
                return true;
            case 10:
                RPCharMenuFunctions.updateRPChar();
                return true;
            case 11:
                System.out.println("Zurück zum Hauptmenü");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }
}
