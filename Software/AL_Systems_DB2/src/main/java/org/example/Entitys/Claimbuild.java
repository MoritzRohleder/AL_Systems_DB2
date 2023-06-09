package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.ClaimbuildType;

import java.util.Set;

//@Entity
//@Table(name = "Claimbuild")
public class Claimbuild {
    //@Id
    //@GeneratedValue
    private int id;
    private String name;
    //@Enumerated(EnumType.STRING)
    private ClaimbuildType type;
    //@Embedded
    /*@AttributeOverrides(
            @AttributeOverride(name = "x", column = @Column(name = "cbXCoord")),
            @AttributeOverride(name = "y", column = @Column(name = "cbYCoord")),
            @AttributeOverride(name = "z", column = @Column(name = "cbZCoord"))
    )*/
    private CoordinatesEmbed coords;

    //@ManyToOne
    //@JoinColumn(name = "regionnumber", nullable = false)
    private Region region;

    //@ManyToOne
    //@JoinColumn(name="controllingFaction", nullable = false)
    private Faction controllingFaction;

    //@OneToMany(mappedBy = "claimbuild")
    Set<UsedProductionSite> productionSites;

    public Claimbuild() {
    }

    public Claimbuild(String name, ClaimbuildType type) {
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ClaimbuildType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClaimbuildType getType() {
        return type;
    }
}
