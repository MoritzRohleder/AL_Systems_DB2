package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.Alignment;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Faction")
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
    @Enumerated(EnumType.STRING)
    private Alignment alignment;
    @ElementCollection()
    private Set<String> aliases = new HashSet<>();
    //@OneToOne
    //@JoinColumn(name = "regionumber", referencedColumnName = "regionnumber")
    //private Region homeRegion;

    @OneToMany(mappedBy = "faction")
    private Set<Player> players;

    //@OneToMany(mappedBy = "ally")
    //private Set<Faction> allies;

    //@OneToMany(mappedBy = "controllingFaction")
    //private Set<Claimbuild> claimbuilds;

    @OneToOne
    @JoinColumn(name = "leaderChar_id", referencedColumnName = "id")
    private RPChar leader;

    public Faction(){

    }

    public Faction(String name, String buff, String colorCode, Alignment alignment){
        this.name = name;
        this.buff = buff;
        this.colorCode = colorCode;
        this.alignment = alignment;
        this.leader = null;
        //this.homeRegion = null;
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

    //public Set<Claimbuild> getClaimbuilds() {return claimbuilds;}

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

    @Override
    public String toString(){
        return String.format("%s using the %s Alignment and the Color %s\n" +
                "Buff is: %s", name, alignment.name(), colorCode, buff);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Faction){
            Faction compFac = (Faction) obj;
            if (compFac.getName().equals(this.getName())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
