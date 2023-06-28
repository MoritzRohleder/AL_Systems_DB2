package org.example.Entitys;

import jakarta.persistence.*;
import jdk.jfr.Registered;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RPChar")
public class RPChar {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "pvp", nullable = false)
    private boolean pvp;

    @OneToOne
    @JoinColumn(name = "player_uuid", referencedColumnName = "uuid")
    private Player player;

    @ManyToMany
    @JoinTable(
            name = "armours",
            joinColumns = @JoinColumn(name = "RPChar_ID"),
            inverseJoinColumns = @JoinColumn(name = "Armour_ID"))
    private Armour[] armours = new Armour[8];

    @ManyToMany
    @JoinTable(
            name = "weapons",
            joinColumns = @JoinColumn(name = "RPChar_ID"),
            inverseJoinColumns = @JoinColumn(name = "Weapon_ID")
    )
    private List<Weapon> weapons = new ArrayList<>();

    public RPChar(){

    }

    public RPChar(String name, String title, boolean pvp){
        this.name = name;
        this.title = title;
        this.pvp = pvp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPvp() {
        return pvp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPvp(boolean pvp) {
        this.pvp = pvp;
    }
}
