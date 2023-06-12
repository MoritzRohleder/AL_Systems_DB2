package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.RegionType;

import java.util.Set;

@Entity
public class Region {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type", nullable = false)
    private RegionType type;

    @OneToMany(mappedBy = "region")
    private Set<Claimbuild> claimbuilds;

    public Region() {
    }

    public Region(String name, RegionType type) {
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
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
