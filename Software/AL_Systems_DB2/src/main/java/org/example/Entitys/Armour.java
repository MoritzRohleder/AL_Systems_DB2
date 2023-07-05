package org.example.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Armour")
public class Armour extends Gear{
    private String type;
    private double protection;

    @ManyToMany(mappedBy = "armours")
    private List<RPChar> rpchar = new ArrayList<>();
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

    @Override
    public String toString(){
        return String.format("%s of Type %s with %s Protection", super.toString(), type, protection);
    }
}
