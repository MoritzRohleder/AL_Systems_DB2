package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.ProductionSideType;
import org.example.Enums.Resource;

import java.util.Set;

@Entity
public class ProdSite {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private ProductionSideType type;
    @OneToMany(mappedBy = "productionSite")
    private Set<UsedProductionSite> usingClaimbuilds;

    public ProdSite() {
    }

    public ProdSite(ProductionSideType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public ProductionSideType getType() {
        return type;
    }

    public void setType(ProductionSideType type) {
        this.type = type;
    }
}
