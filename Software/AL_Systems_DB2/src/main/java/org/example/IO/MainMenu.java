package org.example.IO;

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
                //TODO Ausrüstung nach Material anzeigen
                //Alle Rüstungen und alle Waffen mit diesem Material holen
                // und in einer Liste zusammenfügen, dann die neue Liste
                // ausgeben
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
                //TODO Rüstungen nach ID suchen
                return true;
            case 3:
                //TODO Rüstungen nach Name suchen
                return true;
            case 4:
                //TODO Rüstungen nach Typ suchen
                return true;
            case 5:
                //TODO Rüstungen nach Material suchen
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
                //TODO Waffe nach ID suchen
                return true;
            case 3:
                //TODO Waffe nach Name suchen
                return true;
            case 4:
                //TODO Waffen nach Typ suchen
                return true;
            case 5:
                //TODO Waffen nach Material suchen
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
                //TODO Volk ändern
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
                           + "Zurück [7]");

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
                //TODO Spieler nach UUID suchen
                return true;
            case 3:
                //TODO Spieler nach IGN suchen
                return true;
            case 4:
                //TODO Spieler nach DiscordID suchen
                return true;
            case 5:
                //TODO Volk eines Spielers ausgeben
                //Spieler auswählen, dann Faction von diesem ausgeben
                return true;
            case 6:
                //TODO Rollenspiel-Charakter eines Spielers ausgeben
            case 7:
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
                           + "Zurück [8]");

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
                //TODO Charaktere nach Spiel Präferenz ausgeben
                return true;
            case 3:
                //TODO Charakter nach ID suchen
                return true;
            case 4:
                //TODO Charakter nach Name suchen
                return true;
            case 5:
                //TODO Spieler eines Charakters ausgeben
                //RPChar auswählen, dann einfach den Spieler von diesem ausgeben
                return true;
            case 6:
                //TODO Alle Rüstungen eines Charakters
                //RPChar auswählen, dann einfach die Rüstungen von diesem ausgeben
                return true;
            case 7:
                //TODO Alle Waffen eines Charakters
                //RPChar auswählen, dann einfach die Waffen von diesem ausgeben
                return true;
            case 8:
                System.out.println("Zurück zum Hauptmenü");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }
}
