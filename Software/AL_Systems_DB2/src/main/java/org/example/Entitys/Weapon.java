package org.example.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Weapon")
public class Weapon extends Gear{
    private String type;
    private double dmg;

    @ManyToMany(mappedBy = "weapons")
    private List<RPChar> rpchars = new ArrayList<>();

    public Weapon() {
        super();
    }

    public Weapon(String name, int durability, String type, double dmg) {
        super(name, durability);
        this.type = type;
        this.dmg = dmg;
    }

    public String getType() {
        return type;
    }

    public double getDmg() {
        return dmg;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }
}
