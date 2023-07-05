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

    public static void persistFaction(Faction faction){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(faction);
        em.getTransaction().commit();
        em.close();
    }

    public static void persistArmour(Armour armour){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(armour);
        em.getTransaction().commit();
        em.close();
    }

    public static Armour loadArmourByName(String name){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Armour> query = em.createQuery("SELECT a FROM Armour a WHERE a.name = '" + name + "'", Armour.class);
        Armour armour = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return armour;
    }

    public static Armour[] loadArmourByRPChar(RPChar rpChar){
        em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT a FROM Armour a "
                                                  + "WHERE a.rpchar IN '" + rpChar + "'");
        List armours = List.of(query.getResultList());
        em.getTransaction().commit();
        em.close();
        Armour[] armoursArray = new Armour[armours.size()];
        armours.toArray(armoursArray);
        return armoursArray;
    }

    public static void persistWeapon(Weapon weapon){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(weapon);
        em.getTransaction().commit();
        em.close();
    }

    public static Faction loadFactionByName(String name){
        em = getEntityManager();
        TypedQuery<Faction> query = em.createQuery("SELECT f FROM Faction f WHERE f.name = '" + name + "'", Faction.class);
        Faction fac = query.getSingleResult();
        em.close();
        return fac;
    }

    public static void persistPlayer(Player player){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(player);
        em.getTransaction().commit();
        em.close();
    }

    public static Player loadPlayerByIGN(String name){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p WHERE p.ign = '" + name + "'", Player.class);
        Player p = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return p;
    }

    public static Player loadPlayerByDiscordID(String discordID){
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p WHERE p.discordID = '" + discordID + "'", Player.class);
        Player p = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return p;
    }

    public static void persistRPChar(RPChar rpchar){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(rpchar);
        em.getTransaction().commit();
        em.close();
    }

    public static RPChar loadRPCharByName(String name) {
        em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<RPChar> query = em.createQuery("SELECT rpc FROM RPChar rpc"
                                                  + " WHERE  rpc.name = '" + name + "'", RPChar.class);
        RPChar rpc = query.getSingleResult();
        rpc.setArmours(loadArmourByRPChar(rpc));
        em.getTransaction().commit();
        em.close();
        return rpc;
    }

    public static void deleteEntry(Object entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(entity) ? entity: em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Object entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.refresh(entity);
        em.getTransaction().commit();
        em.close();
    }

    /*public static void persistClaimbuild(Claimbuild cb){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cb);
        em.getTransaction().commit();
        em.close();
    }*/

    /*public static void persistProdSite(ProdSite prodSite){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(prodSite);
        em.getTransaction().commit();
        em.close();
    }*/

    /*public static void persistRegion(Region region){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(region);
        em.getTransaction().commit();
        em.close();
    }*/

    /*public static void persistSpecialBuild(SpecialBuild specialBuild){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(specialBuild);
        em.getTransaction().commit();
        em.close();
    }*/

}
