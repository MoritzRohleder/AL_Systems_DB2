package org.example.DBConntection;

import jakarta.persistence.*;
import org.example.Entitys.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.type.AnyType;

import java.util.LinkedList;
import java.util.List;

public class DBManager {

    @PersistenceUnit
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

    @PersistenceContext
    static EntityManager em;

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    /*
    Armour Querys
     */
    public static List<Armour> loadArmourFullTable(){
        List<Armour> armours;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT a FROM Armour a", Armour.class);
        armours = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return armours;
    }

    public static Armour loadArmourByID(int id){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Armour> query = em.createQuery("SELECT a FROM Armour a "
                                                  + "WHERE a.id = '" + id +"'",
                                                  Armour.class);
        Armour armour = null;
        try {
            armour = query.getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e){
            System.out.println("We could not find Armour with the id " + id);
        }finally {
            em.close();
        }
        return armour;
    }

    public static Armour loadArmourByName(String name){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Armour> query = em.createQuery("SELECT a FROM Armour a WHERE a.name = '" + name + "'", Armour.class);
        Armour armour = null;
        try {
            armour = query.getSingleResult();
            em.getTransaction().commit();
        }catch(NoResultException e){
            System.out.println("We could not find Armor with Name " + name);
        }finally {
            em.close();
        }
        return armour;
    }

    public static List<Armour> loadArmoursByType(String type){
        List<Armour> armours;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT a FROM Armour a WHERE a.type = "
                                     + "'" + type + "'");
        armours = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return armours;
    }

    public static List<Armour> loadArmoursByMaterial(String material){
        List<Armour> armours;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT a FROM Armour a WHERE a.name "
                                     + "LIKE '" + material + "%'");
        armours = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return armours;
    }

    /*
    Weapon Querys
     */
    public static List<Weapon> loadWeaponFullTable(){
        List<Weapon> weapons;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT w FROM Weapon w", Weapon.class);
        weapons = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return weapons;
    }

    public static Weapon loadWeaponByID(int id){
        Weapon weapon = null;
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Weapon> query =
                em.createQuery("SELECT w FROM Weapon w WHERE w.id = '" + id +
                               "'", Weapon.class);
        try {
            weapon = query.getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e){
            System.out.println("We couldn´t find a weapon with the ID " + id);
        }finally {
            em.close();
        }
        return weapon;
    }

    public static Weapon loadWeaponByName(String name){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Weapon> query = em.createQuery("SELECT w FROM Weapon w "
                                                  + "WHERE w.name = '" + name + "'",
                                                  Weapon.class);
        Weapon weapon = null;
        try {
            weapon = query.getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e){
            em.close();
        }
        return weapon;
    }

    public static List<Weapon> loadWeaponsByType(String type){
        List<Weapon> weapons;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT a FROM Weapon a WHERE a.type = "
                + "'" + type + "'");
        weapons = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return weapons;
    }

    public static List<Weapon> loadWeaponByMaterial(String material){
        List<Weapon> weapons;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT w FROM Weapon w WHERE w.name "
                                     + "LIKE '" + material + "%'");
        weapons = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return weapons;
    }

    /*
    Faction Querys
     */
    public static List<Faction> loadFactionFullTable(){
        List<Faction> factions;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT f FROM Faction f", Faction.class);
        factions = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return factions;
    }

    public static Faction loadFactionByID(int id){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Faction> query = em.createQuery("SELECT f FROM Faction f "
                                                   + "WHERE f.id = '" + id +
                                                   "'", Faction.class);
        Faction fac = null;
        try {
            fac = query.getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e){
            System.out.println("We could not find Faction with name " + id);
        }finally {
            em.close();
        }
        return fac;
    }

    public static Faction loadFactionByName(String name){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Faction> query = em.createQuery("SELECT f FROM Faction f WHERE f.name = '" + name + "'", Faction.class);
        Faction fac = null;
        try {
            fac = query.getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e){
            System.out.println("We could not find Faction with name " + name);
        }finally {
            em.close();
        }
        return fac;
    }

    public static List<Player> loadPlayersOfFaction(int fac){
        List<Player> facMembers;
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p "
                                                  + "WHERE p.faction = '" + fac + "'",
                                                  Player.class);
        facMembers = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return facMembers;
    }

    /*
    Player Querys
     */
    public static List<Player> loadPlayerFullTable(){
        List<Player> players;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT p FROM Player p", Player.class);
        players = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return players;
    }

    public static Player loadPlayerByUUID(String uuid){
        Player player = null;
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p "
                                                  + "WHERE p.uuid = '" + uuid + "'",
                                                  Player.class);
        try {
            player = query.getSingleResult();
            em.getTransaction().commit();
        }catch(NoResultException e){
            System.out.println("We could not find a Player with the UUID " + uuid);
        }finally {
            em.close();
        }
        return player;
    }

    public static Player loadPlayerByIGN(String name){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p WHERE p.ign = '" + name + "'", Player.class);
        Player p = null;
        try {
            p = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
        }catch(NoResultException e){
            System.out.println("We could not find the Player with IGN " + name);
        }finally {
            em.close();
        }
        return p;
    }

    public static Player loadPlayerByDiscordID(String discordID){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p WHERE p.discordID = '" + discordID + "'", Player.class);
        Player p = null;
        try {
            p = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
        }catch(NoResultException e){
            System.out.println("We could not find the Player with DiscordID " + discordID);
        }finally {
            em.close();
        }
        return p;
    }

    /*
    RPChar Querys
     */
    public static List<RPChar> loadRPCharFullTable(){
        List<RPChar> chars;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT rpc FROM RPChar rpc",
                                     RPChar.class);
        chars = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return chars;
    }

    /*
    TODO loadRPCharByID(int id){}
     */

    public static RPChar loadRPCharByName(String name) {
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<RPChar> query = em.createQuery("SELECT rpc FROM RPChar rpc"
                                                  + " WHERE  rpc.name = '" + name + "'", RPChar.class);
        RPChar rpc = null;
        try{
            rpc = query.getSingleResult();
            em.getTransaction().commit();
        }catch (NoResultException e){
            System.out.println("We could not find the RPChar with the name " + name);
        }finally {
            em.close();
        }
        return rpc;
    }

    public static List<RPChar> loadRPCharsByPvP(boolean pvp){
        List<RPChar> chars;
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT rpc FROM RPChar rpc WHERE rpc"
                                     + ".pvp = " + (pvp ? "1" : "0") + "",
                                     RPChar.class);
        chars = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return chars;
    }

    /*
    Allgemeine Querys
     */
    public static void persist(Object entity){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteEntry(Object entity){
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(entity) ? entity: em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Object entity) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }
}
