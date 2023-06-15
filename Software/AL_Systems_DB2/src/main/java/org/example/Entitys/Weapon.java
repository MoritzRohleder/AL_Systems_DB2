package org.example.Entitys;

import jakarta.persistence.Entity;

@Entity(name = "Weapon")
public class Weapon extends Gear{
    private String type;
    private double dmg;

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
