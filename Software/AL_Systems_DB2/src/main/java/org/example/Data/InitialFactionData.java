package org.example.Data;

import org.example.Entitys.Faction;
import org.example.Enums.Alignment;

import java.util.HashSet;
import java.util.Set;

public class InitialFactionData {

    public static Set<Faction> initializeFactions(){
        Set<Faction> factions = new HashSet<>();

        Faction angmar = new Faction("Angmar", "Attacking armies can force battles into 1v1 with no allies on either side being able to aid.", "#b72d04", Alignment.ANGMAR);
        factions.add(angmar);

        Faction bree = new Faction("Bree", "Every inn generates 100 coins. Can use hobbit and ranger units. 2x trading company speed.", "#4d4f20", Alignment.BREE);
        factions.add(bree);

        Faction dale = new Faction("Dale", "2 extra traders in towns. Every trade agreement that Dale has set up generates 250 coins monthly for both factions.", "#17515a", Alignment.DALE);
        factions.add(dale);

        Faction dolAmroth = new Faction();
        factions.add(dolAmroth);

        Faction dolGuldur = new Faction();
        factions.add(dolGuldur);

        Faction dorwinion = new Faction();
        factions.add(dorwinion);

        Faction dunland = new Faction();
        factions.add(dunland);

        Faction durinsFolk = new Faction();
        factions.add(durinsFolk);

        Faction eredLuinDwarves = new Faction();
        factions.add(eredLuinDwarves);

        Faction gondor = new Faction();
        factions.add(gondor);

        Faction gulfOfHarad = new Faction();
        factions.add(gulfOfHarad);

        Faction gundabad = new Faction();
        factions.add(gundabad);

        Faction halfTrolls = new Faction();
        factions.add(halfTrolls);

        Faction harnennor = new Faction();
        factions.add(harnennor);

        Faction hobbits = new Faction();
        factions.add(hobbits);

        Faction isengard = new Faction();
        factions.add(isengard);

        Faction lindon = new Faction();
        factions.add(lindon);

        Faction lothlorien = new Faction();
        factions.add(lothlorien);

        Faction mordor = new Faction();
        factions.add(mordor);

        Faction morwaith = new Faction();
        factions.add(morwaith);

        Faction nomads = new Faction();
        factions.add(nomads);

        Faction rangers = new Faction();
        factions.add(rangers);

        Faction rhudel = new Faction();
        factions.add(rhudel);

        Faction rivendell = new Faction();
        factions.add(rivendell);

        Faction rohan = new Faction();
        factions.add(rohan);

        Faction southronCoast = new Faction();
        factions.add(southronCoast);

        Faction taurethrim = new Faction();
        factions.add(taurethrim);

        Faction umbar = new Faction();
        factions.add(umbar);

        Faction woodlandRealm = new Faction();
        factions.add(woodlandRealm);

        Faction wanderer = new Faction();
        factions.add(wanderer);

        return factions;
    }

    public static void pushFactions(Set<Faction> factions){
        System.out.println("Factions erfolgreich zur Datenbank hinzugefügt.");
    }
}
