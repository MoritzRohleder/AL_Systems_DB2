package org.example.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.example.Enums.ClaimbuildType;

@Entity
public class Claimbuild {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private ClaimbuildType type;
    //Koordinaten

    //build by Player
    //controlled by Faction
    //located in Region
    //has ProductionSite
    //has SpecialBuild


    public Claimbuild() {
    }

    public Claimbuild(String name, ClaimbuildType type) {
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ClaimbuildType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClaimbuildType getType() {
        return type;
    }
}
