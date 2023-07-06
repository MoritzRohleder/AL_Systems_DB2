package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Faction;

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
}
