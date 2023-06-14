package org.example.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Armour")
public class Armour extends Gear{
    private String type;
    private double protection;

    public Armour() {
        super();
    }

    public Armour(String name, int durability, String type, double protection) {
        super(name, durability);
        this.type = type;
        this.protection = protection;
    }

    public String getType() {
        return type;
    }

    public double getProtection() {
        return protection;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }
}
