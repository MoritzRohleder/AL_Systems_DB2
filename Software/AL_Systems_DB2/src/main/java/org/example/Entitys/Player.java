package org.example.Entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "Player")
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

    public void setFaction(Faction faction){
        this.faction = faction;
    }

    public Faction getFaction() {
        return faction;
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

    public String forSelect(){
        return String.format("IGN %s/DiscordID %s", ign,
                             discordID);
    }

    @Override
    public String toString(){
        return this != null ? String.format("Player %s with uuid %s and "
                                          + "DiscordID "
                                    + "%s\n" +
                "Member of %s", ign, uuid, discordID, faction.getName()) :
                "Player is null";
    }
}