package org.example.CompositeKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FactionAllyKey implements Serializable {
    @Column(name = "faction_id")
    int factionId;

    @Column(name = "ally_id")
    int allyId;

    public FactionAllyKey() {
    }

    public FactionAllyKey(int factionId, int allyId) {
        this.factionId = factionId;
        this.allyId = allyId;
    }

    public int getFactionId() {
        return factionId;
    }

    public int getAllyId() {
        return allyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FactionAllyKey that = (FactionAllyKey) o;

        if (getFactionId() != that.getFactionId()) return false;
        return getAllyId() == that.getAllyId();
    }

    @Override
    public int hashCode() {
        int result = getFactionId();
        result = 31 * result + getAllyId();
        return result;
    }
}
