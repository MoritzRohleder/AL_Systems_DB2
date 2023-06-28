package org.example.Data;

import org.example.Entitys.ProdSite;
import org.example.Enums.ProductionSiteType;

import java.util.HashSet;
import java.util.Set;

public class InitialProdSiteData {
    public static Set<ProdSite> initialiseProdSites(){
        Set<ProdSite> productionSites = new HashSet<>();

        ProdSite farm = new ProdSite(ProductionSiteType.Farm);
        productionSites.add(farm);

        ProdSite slaughterhouse = new ProdSite(ProductionSiteType.Slaughterhouse);
        productionSites.add(slaughterhouse);

        ProdSite huntingLodge = new ProdSite(ProductionSiteType.HuntingLodge);
        productionSites.add(huntingLodge);

        ProdSite fishingLodge = new ProdSite(ProductionSiteType.FishingLodge);
        productionSites.add(fishingLodge);

        ProdSite orchard = new ProdSite(ProductionSiteType.Orchard);
        productionSites.add(orchard);

        ProdSite manfleshPit = new ProdSite(ProductionSiteType.ManFleshPit);
        productionSites.add(manfleshPit);

        ProdSite lumbercamp = new ProdSite(ProductionSiteType.LumberCamp);
        productionSites.add(lumbercamp);

        ProdSite quarry = new ProdSite(ProductionSiteType.Quarry);
        productionSites.add(quarry);

        ProdSite mineshaft = new ProdSite(ProductionSiteType.Mine);
        productionSites.add(mineshaft);

        ProdSite workshop = new ProdSite(ProductionSiteType.Workshop);
        productionSites.add(workshop);

        ProdSite pearlFisher = new ProdSite(ProductionSiteType.PearlFisher);
        productionSites.add(pearlFisher);

        ProdSite houseOfLore = new ProdSite(ProductionSiteType.HouseOfLore);
        productionSites.add(houseOfLore);

        ProdSite dyeHouse = new ProdSite(ProductionSiteType.DyeHouse);
        productionSites.add(dyeHouse);

        return productionSites;
    }
}
