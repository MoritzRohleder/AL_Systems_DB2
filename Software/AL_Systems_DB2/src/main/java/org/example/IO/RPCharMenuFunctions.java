package org.example.IO;

import org.example.DBConntection.DBManager;
import org.example.Entitys.Player;
import org.example.Entitys.RPChar;

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
}
