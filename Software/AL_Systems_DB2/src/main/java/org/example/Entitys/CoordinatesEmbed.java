package org.example.Entitys;

import jakarta.persistence.Embeddable;

@Embeddable
public class CoordinatesEmbed {
    private double x;
    private double y;
    private double z;
}
