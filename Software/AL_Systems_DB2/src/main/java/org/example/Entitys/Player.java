package org.example.Entitys;

import jakarta.persistence.*;

@Entity
public class Player {
    @Column(name = "uuid")
    @Id
    private String uuid;
    @Column(name = "ign", nullable = false)
    private String ign;
    @Column(name = "discordID")
    private String discordID;

    @OneToOne(mappedBy = "player")
    private RPChar rpchar;

    @ManyToOne
    @JoinColumn(name = "faction", nullable = true)
    private Faction faction;

    public Player() {

    }

    public Player(String uuid, String ign, String discordID){
        this.uuid = uuid;
        this.ign = ign;
        this.discordID = discordID;
    }

    public String getUuid() {
        return uuid;
    }

    public String getIgn() {
        return ign;
    }

    public String getDiscordID() {
        return discordID;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }

    public void setDiscordID(String discordID) {
        this.discordID = discordID;
    }
}