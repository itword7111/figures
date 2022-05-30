package com.example.figures.entity;

import javax.persistence.*;

@Entity
@Table(name = "circle", schema = "figure")
public class Circle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "color")
    private String color;
    @Column(name = "radius")
    private Double radius;

    public Circle(String color, Double radius) {
        this.color = color;
        this.radius = radius;
    }

    public Circle() {
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
