package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Faction;
import org.example.Entitys.Player;

import java.util.List;
import java.util.Scanner;

public class PlayerMenuFunctions {

    private static Scanner sc;

    /**
     * Methode um einen Spieler auszuwählen.
     * Wird zu der eingegebenen DiscordID kein Spieler gefunden, wird null
     * zurückgegeben
     * @return Der Spieler zur eingegebenen DiscordID, bzw null wenn der
     * nicht existiert
     */
    public static Player selectPlayer(){
        System.out.println("Spieler Auswahl:");
        List<Player> playerList = DBManager.loadPlayerFullTable();
        playerList.forEach(player -> System.out.println(player.forSelect()));
        System.out.println("Bitte wählen Sie einen der Spieler aus (DiscordID "
                           + "eingeben)");
        sc = new Scanner(System.in);
        String selected = sc.nextLine();
        return DBManager.loadPlayerByDiscordID(selected);
    }

    public static void addPlayer(){
        sc = new Scanner(System.in);
        Player player;
        System.out.println("Bitte geben Sie die UUID ein:");
        String uuid = sc.nextLine();
        System.out.println("Bitte geben Sie die IGN ein:");
        String ign = sc.nextLine();
        System.out.println("Bitte geben Sie die DiscordID ein:");
        String discord = sc.nextLine();

        player = new Player(uuid, ign, discord);

        try {
            DBManager.persist(player);
            System.out.println("Es wurde Spieler " + player.toString() + " "
                               + "erfolgreich gespeichert.");
        }catch (Exception e){
            System.out.println("Ups da ist was schief gelaufen");
            e.printStackTrace();
        }
    }

    public static void updatePlayer(){
        System.out.println("Welchen Spieler möchten Sie ändern?");
        Player player = selectPlayer();
        if(player ==null){
            System.out.println("Der Spieler wurde nicht gefunden");
            return;
        }
        boolean repeatChange = true;
        while (repeatChange){
            System.out.println(player.toString());
            System.out.println("Was möchten Sie ändern?\n"
                               + "Faction [1]\n"
                               + "Beenden [2]");
            int selected = 0;
            try {
                selected = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein.");
                repeatChange = true;
            }
            switch (selected){
                case 1:
                    Faction fac = FactionMenuFunctions.selectFaction();
                    if(fac == null){
                        System.out.println("Volk wurde nicht gefunden.");
                    }
                    player.setFaction(fac);
                    repeatChange = true;
                    break;
                case 2:
                    repeatChange = false;
                    break;
                default:
                    System.out.println("Bitte geben Sie eine passende Zahl "
                                       + "ein");
                    repeatChange = true;
                    break;
            }
        }
        try {
            DBManager.update(player);
            System.out.println("Spieler geändert.");
        }catch (Exception e){
            System.out.println("Ups da hat was nicht funktioniert");
            e.printStackTrace();
        }
    }
}
