package org.example.IO;

import org.example.DBConntection.DBManager;
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
}
