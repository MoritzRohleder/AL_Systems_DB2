package org.example.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "SpecialBuild")
public class SpecialBuild {
    //@Id
    private String name;
    private String function;

    public SpecialBuild() {
    }

    public SpecialBuild(String name, String function) {
        this.name = name;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
