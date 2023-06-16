package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.ProductionSiteType;

import java.util.Set;

@Entity
public class ProdSite {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private ProductionSiteType type;
    @OneToMany(mappedBy = "productionSite")
    private Set<UsedProductionSite> usingClaimbuilds;

    public ProdSite() {
    }

    public ProdSite(ProductionSiteType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public ProductionSiteType getType() {
        return type;
    }

    public void setType(ProductionSiteType type) {
        this.type = type;
    }
}
