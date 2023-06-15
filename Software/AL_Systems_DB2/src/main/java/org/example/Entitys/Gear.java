package org.example.Entitys;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Gear {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int durability;

    public Gear() {
    }

    public Gear(String name, int durability) {
        this.name = name;
        this.durability = durability;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
