package org.example.Entitys;

import jakarta.persistence.*;
import jdk.jfr.Registered;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "armours",
            joinColumns = @JoinColumn(name = "RPChar_ID"),
            inverseJoinColumns = @JoinColumn(name = "Armour_ID"))
    private Armour[] armours = new Armour[8];

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "weapons",
            joinColumns = @JoinColumn(name = "RPChar_ID"),
            inverseJoinColumns = @JoinColumn(name = "Weapon_ID")
    )
    private List<Weapon> weapons = new ArrayList<>();

    public RPChar(){

    }

    public RPChar(Player player, String name, String title, boolean pvp){
        this.player = player;
        this.name = name;
        this.title = title;
        this.pvp = pvp;
    }

    public void setArmours(Armour[] armours){
        this.armours = armours;
    }

    public void setWeapons(List<Weapon> weapons){
        this.weapons = weapons;
    }

    public void setPlayer(Player player){
        this.player = player;
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

    public boolean getPvp() {
        return pvp;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public Armour[] getArmours() {
        return armours;
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

    public String forSelect(){
        return String.format("%s mit ID %d", name, id);
    }

    @Override
    public String toString(){
        if(this == null){
            return "RPChar is null";
        }
        String armoursString = "";
        for (int i = 0; i < armours.length; i++){
            armoursString += armours[i] != null ? armours[i].getName() :
                    "empty" + ", ";
        }
        String weaponString = "";
        for(int i = 0; i < weapons.size(); i++){
            weaponString += weapons.get(i).getName() + ", ";
        }
        return String.format("%s %s von Spieler %s mit %s\n" +
                "Rüstung: %s\n" +
                "Waffen: %s", name, title, player != null ? player.getIgn() :
                                     "empty",
                             pvp ? "PvP" :
                                     "PvE",
                             armoursString, weaponString);
    }
}
