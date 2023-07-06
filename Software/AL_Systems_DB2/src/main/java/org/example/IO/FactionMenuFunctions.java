package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Faction;
import org.example.Entitys.Player;
import org.example.Entitys.RPChar;
import org.example.Enums.Alignment;

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

    /**
     * Methode um ein Volk hinzuzufügen
     */
    public static void addFaction(){
        System.out.println("Volk hinzufügen:");
        sc = new Scanner(System.in);
        Faction newFac;
        System.out.println("Bitte geben Sie einen Namen für das Volk ein:");
        String facName = sc.nextLine();
        System.out.println("Bitte geben Sie den Buff des Volkes ein:");
        String facBuff = sc.nextLine();
        System.out.println("Bitte geben Sie den Farbcode des Volkes ein:");
        String facColor = sc.nextLine();
        String facAlignment = "";
        boolean repeatAlign = true;
        while(repeatAlign){
            try{
                System.out.println("Bitte geben Sie das InGame-Alignment des Volkes "
                                   + "ein:");
                facAlignment = sc.nextLine();
                Alignment test = Alignment.valueOf(facAlignment);
                repeatAlign = false;
            }catch (IllegalArgumentException e){
                System.out.println("Bitte geben Sie einen gültigen Alignment-Wert"
                                   + " an.");
                Alignment[] alignments = Alignment.values();
                for (Alignment alignment : alignments) {
                    System.out.print(alignment.name() + ", ");
                }
                repeatAlign = true;
            }
        }
        newFac = new Faction(facName, facBuff, facColor,
                             Alignment.valueOf(facAlignment));
        try {
            DBManager.persist(newFac);
            System.out.println("Erfolgreich hinzugefügt wurde \n" + newFac.toString());
        }catch (Exception e){
            System.out.println("Ups da hat was nicht funktioniert.");
            e.printStackTrace();
        }
    }

    /**
     * Methode, welche die FacSelection aufruft und die ausgewählte Faction
     * löscht, wenn möglich und sicher.
     */
    public static void deleteFaction(){
        Faction fac = selectFaction();
        if(fac == null){
            System.out.println("Das Volk konnte nicht gefunden werden.");
            return;
        }
        if(fac.getLeader() != null){
            System.out.println("Sie können das Volk nicht löschen, da es "
                               + "einen eingetragenen Anführer hat.\n"
                               + "Bearbeiten Sie das Volk und nehmen Sie den "
                               + "Anführer raus.\nV"
                               + "ersuchen Sie es dann nochmal.");
            return;
        }
        System.out.println("Sicher, dass Sie folgendes Volk löschen möchten? "
                           + "(J/N");
        System.out.println(fac);
        sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        switch (input){
            case "j":
                try {
                    DBManager.deleteEntry(fac);
                    System.out.println("Das Volk wurde gelöscht");
                }catch (Exception e){
                    System.out.println("Ups, da hat was nicht funktioniert");
                    e.printStackTrace();
                }
                break;
            case "n":
                System.out.println("Das Volk wird nicht gelöscht.");
                break;
            default:
                System.out.println("Die Eingabe konnte nicht verarbeitet "
                                   + "werden.");
                break;
        }
    }

    /**
     * Methode um ein ausgewähltes VOlk zu ändern.
     */
    public static void updateFaction(){
        //TODO
    }
}
