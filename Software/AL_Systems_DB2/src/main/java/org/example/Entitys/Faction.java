package org.example.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.example.Enums.Alignment;

import java.util.Set;

@Entity
public class Faction {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "faction", nullable = false)
    private String name;
    @Column(name = "buff", nullable = false)
    private String buff;
    @Column(name = "color", nullable = false)
    private String colorCode;
    @Column(name = "alignment", nullable = false)
    private Alignment alignment;
    //private Set<String> aliases;

    public Faction(){

    }

    Faction(String name, String buff, String colorCode, Alignment alignment){
        this.name = name;
        this.buff = buff;
        this.colorCode = colorCode;
        this.alignment = alignment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBuff() {
        return buff;
    }

    public String getColorCode() {
        return colorCode;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuff(String buff) {
        this.buff = buff;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }
}
