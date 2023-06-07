package org.example.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.example.Enums.RegionType;

@Entity
public class Region {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type", nullable = false)
    private RegionType type;

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
