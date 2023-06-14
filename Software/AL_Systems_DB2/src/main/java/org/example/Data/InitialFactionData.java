package org.example.Data;

import org.example.Entitys.Faction;
import org.example.Enums.Alignment;

import java.security.InvalidAlgorithmParameterException;
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

        Faction dolAmroth = new Faction("Dol Amroth", "The Faction Leader and Lords of Dol Amroth are granted one Lindon weapon of their choice and 1 swiftness potion per battle. This potion do not count towards the 1 brew rule.", "#c1ffff", Alignment.GONDOR);
        factions.add(dolAmroth);

        Faction dolGuldur = new Faction("Dol Guldur", "Can type out an incantation in three separate messages in /me to break down a gate. The incantation is: Gaakh Pluhun, Gaakh Asgaja, Thrak Za Doraz Ghaamul. Immune to Mirkwood attrition.", "#52397c", Alignment.DOL_GULDUR);
        factions.add(dolGuldur);

        Faction dorwinion = new Faction("Dorwinion", "Army upkeep can be paid with 10 barrels of wine monthly instead of coins. In wars, all players must drink 1 cup of potent wine when the battle starts. 2x production for Grape orchards.", "#cd00cd", Alignment.DORWINION);
        factions.add(dorwinion);

        Faction dunland = new Faction("Dunland", "Can raid 2 claimbuild once a month with an army. They will fight a battle to determine if the raid is successful  (empty builds are an auto win) if sucessful, the army will loot up to 3 production sites from the build which will be taken from the next month of CB rewards. If not successful the army is destroyed. 2x movement speed in forests.", "#7e6a61", Alignment.DUNLAND);
        factions.add(dunland);

        Faction durinsFolk = new Faction("Durins Folk", "Villages+ are able to build 1 extra production site that doesn't require 4 houses to activate. Shops aren't effected by this. 2x mountain movement. Immune to snowy mountain attrition.", "#0000cd", Alignment.DWARF);
        factions.add(durinsFolk);

        Faction eredLuinDwarves = new Faction("Ered Luin Dwarves", "2x trader company movement speed. If a smithy is built as a production site in residential builds, the faction can get 1 scroll of their choice per month from the forge. A max of 1 forge is allowed per village and a max of 2 forges is allowed per town or in your capital. Immune to snowy mountain attrition.", "#a6c1f4", Alignment.BLUE_MOUNTAINS);
        factions.add(eredLuinDwarves);

        Faction gondor = new Faction("Gondor", "2x movement in Gondor owned regions.", "#e9e9e9", Alignment.GONDOR);
        factions.add(gondor);

        Faction gulfOfHarad = new Faction("Gulf of Harad", "All armies come with a oliphant as siege (can be used as a siege tower or a ram). Still can have 3 extra siege from workshops, Oliphants are not effected by siege slowdown. Immune to desert attrition.", "#eecfa9", Alignment.NEAR_HARAD);
        factions.add(gulfOfHarad);

        Faction gundabad = new Faction("Gundabad", "2x movement in mountain regions and 16 ladders provided per player in a battle. Immune to Snowy Mountain attrition.", "#5a4132", Alignment.GUNDABAD);
        factions.add(gundabad);

        Faction halfTrolls = new Faction("Half-Trolls", "Can use rhinos in wars. Half-Troll armies cannot retreat. While at war, Half-Trolls do not have to pay upkeep.", "#9f6c60", Alignment.HALF_TROLL);
        factions.add(halfTrolls);

        Faction harnennor = new Faction("Harnennor", "Can build slave pits that generate 100 coins per month, these do not generate man-flesh. Trading companies have a default army that moves with them. This army cannot be bound to or attack, but may be used to defend the trading company.", "#800000", Alignment.NEAR_HARAD);
        factions.add(harnennor);

        Faction hobbits = new Faction("Hobbit", "Can use Huorns as units. 2x production for farms. Immune to swap attrition.", "#7cfc00", Alignment.HOBBIT);
        factions.add(hobbits);

        Faction isengard = new Faction("Isengard", "Can use orc bombs to blow up walls in sieges. To set a bomb off run up and set it off. All armies can carry a max of 4 types of siege.", "#262626", Alignment.URUK_HAI);
        factions.add(isengard);

        Faction lindon = new Faction("Lindon", "2x sailing speed. Does not have to spend 1 day boarding or disembarking a ship.", "#2964d2", Alignment.HIGH_ELF);
        factions.add(lindon);

        Faction lothlorien = new Faction("Lothlórien", "Hedges can be built for any build and force attackers to use siege to take the build. Hedge walls also reduce the trebuchet/catapult brush size staff use to break the wall thus, making the walls take longer to break.", "#ffff00", Alignment.GALADHRIM);
        factions.add(lothlorien);

        Faction mordor = new Faction("Mordor", "The Faction Leader's army can build \"Grond\" which is a ram that instantly breaks gates instead of taking 3 hits. Does not need players nearby to move it. Enemy armies that enter geographical Mordor regions have their time to move through regions doubled.", "#ff0000", Alignment.MORDOR);
        factions.add(mordor);

        Faction morwaith = new Faction("Morwaith", "6 spears in combat and 6 termites allowed in PvP. 2x speed in grassland regions. \n", "#f4a460", Alignment.MOREDAIN);
        factions.add(morwaith);

        Faction nomads = new Faction("Nomads", "Can use other Southron faction units. For each trading company that Nomads have alive, they will gain 1 Southron trader spawn eggs per month. 2x movement in desert regions. Immune to desert attrition.", "#ffec8b", Alignment.NEAR_HARAD);
        factions.add(nomads);

        Faction rangers = new Faction("Dunedain of the North", "Can build athelas farms. The farms provide 12 athelas per month. Must show some athelas in the farm build. 2x movement in forest and hill regions. Immune to swamp attrition.", "#335e48", Alignment.RANGER_NORTH);
        factions.add(rangers);

        Faction rhudel = new Faction("Rhúdel", "Can use khamul's fire in battles. Gold mines built in their capital provide double resources. (A max of 5 are doubled.)", "#c27c0e", Alignment.RHUN);
        factions.add(rhudel);

        Faction rivendell = new Faction("Rivendell", "2x healing speed. Can build athelas farms. The farms provide 12 athelas per month. Must show some athelas in the farm build.", "#49688b", Alignment.HIGH_ELF);
        factions.add(rivendell);

        Faction rohan = new Faction("Rohan", "Horsemen units do not cost an extra unit. 2x movement in grassland regions.", "#30ca30", Alignment.ROHAN);
        factions.add(rohan);

        Faction southronCoast = new Faction("Southron Coast", "2x coin production from builds. Neither Southron armies nor their enemies can retreat from battles.", "#ffda00", Alignment.NEAR_HARAD);
        factions.add(southronCoast);

        Faction taurethrim = new Faction("Taurethrim", "2x movement in forest and jungle regions. Can use an additional 2 traps per build. Immune to jungle attrition.", "#007c23", Alignment.TAUREDAIN);
        factions.add(taurethrim);

        Faction umbar = new Faction("Umbar", "Can raid 2 claimbuild once a month with an army when on the sea. They will fight a battle to determine if the raid is successful  (empty builds are an auto win) if successful, the army will loot up to 5 production sites from the build which will be taken from the next month of CB rewards. If not successful the army is destroyed.", "#ff7f50", Alignment.NEAR_HARAD);
        factions.add(umbar);

        Faction woodlandRealm = new Faction("Woodland Realm", "1 ender pearl and one speed potion are provided to each WLR elf at the start of each battle. 2x movement speed in forest regions. Immune to Mirkwood attrition.", "#002e00", Alignment.WOOD_ELF);
        factions.add(woodlandRealm);

        Faction wanderer = new Faction("Wanderer", "Can aid any faction.", "#ffffff", Alignment.NONE);
        factions.add(wanderer);

        return factions;
    }

    public static void pushFactions(Set<Faction> factions){
        System.out.println("Factions erfolgreich zur Datenbank hinzugefügt.");
    }
}
