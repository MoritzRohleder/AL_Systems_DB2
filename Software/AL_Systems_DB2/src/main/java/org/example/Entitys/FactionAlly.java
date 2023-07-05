package org.example.Entitys;

import jakarta.persistence.*;
import org.example.CompositeKeys.FactionAllyKey;

//@Entity
public class FactionAlly {

    //@EmbeddedId
    FactionAllyKey id;

    //@ManyToOne
    //@MapsId("faction_id")
    //@JoinColumn(name = "faction_id")
    Faction faction;

    //@ManyToOne
    //@MapsId("ally_id")
    //@JoinColumn(name = "ally_id")
    Faction ally;

    public FactionAlly() {
    }

    public FactionAlly(FactionAllyKey id, Faction faction, Faction ally) {
        this.id = id;
        this.faction = faction;
        this.ally = ally;
    }

    public FactionAllyKey getId() {
        return id;
    }

    public Faction getFaction() {
        return faction;
    }

    public Faction getAlly() {
        return ally;
    }
}
