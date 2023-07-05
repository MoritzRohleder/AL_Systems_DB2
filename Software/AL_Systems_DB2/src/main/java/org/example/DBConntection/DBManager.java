package org.example.DBConntection;

import jakarta.persistence.*;
import org.example.Entitys.*;
import org.hibernate.type.AnyType;

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
    TODO Bei allen noch nach ID finden und ganze Tabelle ausgeben
     */

    /*
    Armour Querys
     */
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

    /*
    TODO loadArmourByType(String type){}
    WHERE a.type = type
     */

    /*
    TODO loadArmourByMaterial(String material){}
    WHERE a.name LIKE material%
     */

    /*
    Weapon Querys
     */
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

    /*
    TODO loadWeaponByType(String type){}
    WHERE w.type = type
     */

    /*
    TODO loadWeaponByMaterial(String material){}
    WHERE w.name LIKE material%
     */

    /*
    Faction Querys
     */
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

    /*
    TODO loadFactionLeader(Faction fac){}
     */

    /*
    TODO loadPlayersOfFaction(Faction fac){}
     */

    /*
    Player Querys
     */
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
    TODO loadFactionOfPlayer(Player p){}
     */

    /*
    RPChar Querys
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

    /*
    TODO loadPlayerOfRPChar(RPChar rpc){}
     */

    /*
    TODO loadWeaponsOfRPChar(RPChar rpc){}
     */

    /*
    TODO loadArmourOfRPChar(RPChar rpc){}
     */

    /*
    TODO loadRPCharsByPvP(PvP pvp){}
     */

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
