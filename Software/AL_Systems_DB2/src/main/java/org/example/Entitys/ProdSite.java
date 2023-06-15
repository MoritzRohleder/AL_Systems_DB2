package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.ProductionSideType;
import org.example.Enums.Resource;

@Entity
public class ProdSite {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private ProductionSideType type;
    private Resource resource;
    private int amount;

    public ProdSite() {
    }

    public ProdSite(ProductionSideType type, Resource resource, int amount) {
        this.type = type;
        this.resource = resource;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public ProductionSideType getType() {
        return type;
    }

    public Resource getResource() {
        return resource;
    }

    public int getAmount() {
        return amount;
    }

    public void setType(ProductionSideType type) {
        this.type = type;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
