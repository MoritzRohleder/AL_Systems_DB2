package org.example.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
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
