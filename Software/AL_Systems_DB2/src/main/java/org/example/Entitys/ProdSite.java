package org.example.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.example.Enums.ProductionSideType;
import org.example.Enums.Resource;

@Entity
@Table(name = "Production Side")
public class ProdSite {
    @Id
    @GeneratedValue
    private int id;
    private ProductionSideType type;
    private Resource producedResource;
    private int amount;

    public ProdSite() {
    }

    public ProdSite(ProductionSideType type, Resource producedResource, int amount) {
        this.type = type;
        this.producedResource = producedResource;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public ProductionSideType getType() {
        return type;
    }

    public Resource getProducedResource() {
        return producedResource;
    }

    public int getAmount() {
        return amount;
    }

    public void setType(ProductionSideType type) {
        this.type = type;
    }

    public void setProducedResource(Resource resource) {
        this.producedResource = resource;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
