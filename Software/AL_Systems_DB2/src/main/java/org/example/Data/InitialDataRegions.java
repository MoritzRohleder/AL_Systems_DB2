package org.example.Data;

import org.example.Entitys.Region;
import org.example.Enums.RegionType;

import java.util.HashSet;
import java.util.Set;

public class InitialDataRegions {

    public static Set<Region> initialse(){
        Set<Region> regions = new HashSet<>();

        Region northLindon = new Region("North Lindon", RegionType.PLAINS);

        Region southLindon = new Region("South Lindon", RegionType.PLAINS);

        Region northBlueMountains = new Region("Northern Blue Mountains", RegionType.MOUNTAIN);

        Region southBlueMountains = new Region("Southern Blue Mountains", RegionType.MOUNTAIN);

        Region westNorthlands = new Region("Western Northlands", RegionType.PLAINS);

        Region eriador = new Region("Eriador", RegionType.PLAINS);

        Region shire = new Region("Shire", RegionType.PLAINS);

        Region bree = new Region("Bree", RegionType.PLAINS);

        return regions;
    }
}
