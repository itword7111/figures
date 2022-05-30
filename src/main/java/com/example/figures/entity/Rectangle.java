package com.example.figures.entity;

import javax.persistence.*;

@Entity
@Table(name = "rectangle", schema = "figure")
public class Rectangle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstSide")
    private Double firstSide;
    @Column(name = "secondSide")
    private Double secondSide;
    @Column(name = "color")
    private String color;

    public Rectangle(Double firstSide, Double secondSide, String color) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.color = color;
    }
    public Rectangle(){}

    public Double getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(Double firstSide) {
        this.firstSide = firstSide;
    }

    public Double getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(Double secondSide) {
        this.secondSide = secondSide;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
