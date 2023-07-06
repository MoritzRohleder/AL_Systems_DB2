package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Faction;
import org.example.Entitys.Player;
import org.example.Entitys.RPChar;

import java.util.List;
import java.util.Scanner;

public class FactionMenuFunctions {

    private static Scanner sc;

    /**
     * Methode zum auswählen eines Volks.
     * Wird ein nicht existierendes Volk ausgewählt, wird null zurück gegeben
     *
     * @return das ausgewählte Volk, bzw null wenn das ausgewählte nicht
     * existiert
     */
    public static Faction selectFaction(){
        System.out.println("Volk Auswahl:");
        List<Faction> facList = DBManager.loadFactionFullTable();
        facList.forEach(faction -> System.out.println(faction.forSelect()));
        System.out.println("Bitte wählen Sie eins der Völker (ID eingeben)");
        sc = new Scanner(System.in);
        int selected;
        boolean repeatInput = true;
        while(repeatInput){
            try{
                selected = Integer.parseInt(sc.nextLine());
                return DBManager.loadFactionByID(selected);
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein.");
                repeatInput = true;
            }
        }
        return null;
    }

    /**
     * Methode, die eine Faction nach der gegebenen ID sucht.
     */
    public static void searchFacByID(){
        System.out.println("Bitte geben Sie eine ID (Nummerischer Wert) ein, "
                           + "nach welcher Sie suchen möchten.");
        sc = new Scanner(System.in);
        int id = 0;
        boolean repeatInput = true;
        while(repeatInput){
            try{
                id = Integer.parseInt(sc.nextLine());
                repeatInput = false;
            }catch (NumberFormatException e){
                System.out.println("Bitte geben Sie eine Zahl ein.");
                repeatInput = true;
            }
        }
        Faction fac = DBManager.loadFactionByID(id);
        System.out.println(fac != null ? fac : "Kein Volk zu der ID " + id +
                                               " gefunden.");
    }

    /**
     * Methode, die eine Faction nach dem gegebenen Namen sucht.
     */
    public static void searchFacByName(){
        System.out.println("Bitte geben Sie einen Völkernamen ein, nach dem "
                           + "Sie suchen möchten.");
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        Faction fac = DBManager.loadFactionByName(name);
        System.out.println(fac != null ? fac :
                                   "Kein Volk mit Namen " + name + " gefunden");
    }

    /**
     * Methode, die den Faction Leader der ausgewählten Faction auf der
     * Console ausgibt.
     */
    public static void getLeaderOfFac(){
        Faction fac = selectFaction();
        if(fac != null){
            RPChar leader = fac.getLeader();
            System.out.println(leader != null ? leader :
                                       "Das Volk " + fac.getName() + " hat"
                                       + " keinen Anführer.");
        }else{
            System.out.println("Das ausgwählte Volk ist nicht in der "
                               + "Datenbank.");
        }
    }

    /**
     * Methode, welche alle Mitglieder der ausgewählten Faction ausgibt.
     */
    public static void getMembersOfFac(){
        Faction fac = selectFaction();
        List<Player> members = DBManager.loadPlayersOfFaction(fac.getId());
        if(members.isEmpty()){
            System.out.println("Das Volk " + fac +  "hat keine Mitglieder.");
        }else{
            members.forEach(member -> System.out.println(member));
        }
    }
}
