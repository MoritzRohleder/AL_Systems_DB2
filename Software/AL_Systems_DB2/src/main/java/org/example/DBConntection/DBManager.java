package org.example.DBConntection;

import jakarta.persistence.*;
import org.example.Entitys.*;

public class DBManager {

    @PersistenceUnit
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

    @PersistenceContext
    static EntityManager em;

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void persistClaimbuild(Claimbuild cb){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cb);
        em.getTransaction().commit();
        em.close();
    }

    public static void persistFaction(Faction faction){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(faction);
        em.getTransaction().commit();
        em.close();
    }

    public static void persistPlayer(Player player){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(player);
        em.getTransaction().commit();
        em.close();
    }

    public static void persistProdSite(ProdSite prodSite){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(prodSite);
        em.getTransaction().commit();
        em.close();
    }

    public static void persistRegion(Region region){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(region);
        em.getTransaction().commit();
        em.close();
    }

    public static void persistRPChar(RPChar rpchar){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(rpchar);
        em.getTransaction().commit();
        em.close();
    }

    public static void persistSpecialBuild(SpecialBuild specialBuild){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(specialBuild);
        em.getTransaction().commit();
        em.close();
    }

}
