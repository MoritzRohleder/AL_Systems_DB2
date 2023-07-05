package org.example.Entitys;

import jakarta.persistence.*;
import org.example.Enums.Resource;

//@Entity
public class UsedProductionSite {
    //@Id
    //@GeneratedValue
    private int id;

    //@ManyToOne
    //@JoinColumn(name = "claimbuild_ID")
    private Claimbuild claimbuild;

    //@ManyToOne
    //@JoinColumn(name = "productionSite_ID")
    private ProdSite productionSite;

    //@Enumerated(EnumType.STRING)
    private Resource resource;

    private int amount;
}
