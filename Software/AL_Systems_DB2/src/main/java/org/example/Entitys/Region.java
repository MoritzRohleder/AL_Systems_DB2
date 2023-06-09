package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.RegionType;

import java.util.Set;

//@Entity
//@Table(name = "Region")
public class Region {
    //@Id
    //@GeneratedValue
    private int regionnumber;
    //@Column(name = "name", nullable = false)
    private String name;
    //@Column(name = "type", nullable = false)
    //@Enumerated(EnumType.STRING)
    private RegionType type;

    //@OneToMany(mappedBy = "region")
    private Set<Claimbuild> claimbuilds;

    public Region() {
    }

    public Region(String name, RegionType type) {
        this.name = name;
        this.type = type;
    }

    public int getRegionnumber() {
        return regionnumber;
    }

    public String getName() {
        return name;
    }

    public RegionType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(RegionType type) {
        this.type = type;
    }
}
