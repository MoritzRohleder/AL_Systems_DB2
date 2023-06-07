package org.example.IO;

import java.util.Scanner;

public class MainMenu {

    private static Scanner sc;

    /**
     * Die Methode run() ruft so lange die mainMenu() Funktion auf, bis diese false zurück gibt.
     */
    public static void run(){
        boolean repeat = true;
        while(repeat){
            repeat = mainMenu();
        }
    }

    /**
     * Das Hauptmenü der Konsolen Anwendung.
     * Hier wählt der Nutzer die Funktion aus, welche er ausführen möchte.
     *
     * @returns false wenn Beenden [6] ausgewählt wird, ansonsten true
     */
    private static boolean mainMenu(){
        System.out.println("Willkommen zum DB-Manager des Arda's Legends Systems.\n" +
                "Bitte wählen Sie eine Funktion aus:\n" +
                "Tabelle anzeigen [1]\n" +
                "Nach einem bestimmten Eintrag suchen [2]\n" +
                "Eintrag aktualisieren [3]\n" +
                "Eintrag löschen [4]\n" +
                "Eintrag einfügen [5]\n" +
                "Beenden [6]");

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
                System.out.println("Tabelle anzeigen ausgewählt");
                return true;
            case 2:
                System.out.println("Nach einem bestimmten Eintrag suchen ausgewählt");
                return true;
            case 3:
                System.out.println("Eintrag aktualisieren ausgewählt");
                return true;
            case 4:
                System.out.println("Eintrag löschen ausgewählt");
                return true;
            case 5:
                System.out.println("Eintrag einfügen ausgewählt");
                return true;
            case 6:
                System.out.println("Beenden ausgewählt");
                return false;
            default:
                System.out.println("Bitte geben Sie eine passende Zahl ein.");
                return true;
        }
    }
}
