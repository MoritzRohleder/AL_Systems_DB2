package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.ClaimbuildType;

@Entity
public class Claimbuild {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private ClaimbuildType type;
    @Embedded
    /*@AttributeOverrides(
            @AttributeOverride(name = "x", column = @Column(name = "cbXCoord")),
            @AttributeOverride(name = "y", column = @Column(name = "cbYCoord")),
            @AttributeOverride(name = "z", column = @Column(name = "cbZCoord"))
    )*/
    private CoordinatesEmbed coords;

    @ManyToOne
    @JoinColumn(name = "regionnumber", nullable = false)
    private Region region;

    @ManyToOne
    @JoinColumn(name="controllingFaction", nullable = false)
    private Faction controllingFaction;


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
