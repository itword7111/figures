package com.example.figures.model;

public class CircleDto implements FigureDto {
    private String color;
    private Double radius;
    private Double area;
    private Double circumferenceLength;

    public CircleDto() {
    }

    public CircleDto(String color, Double radius, Double area, Double circumferenceLength) {
        this.color = color;
        this.radius = radius;
        this.area = area;
        this.circumferenceLength = circumferenceLength;
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

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCircumferenceLength() {
        return circumferenceLength;
    }

    public void setCircumferenceLength(Double circumferenceLength) {
        this.circumferenceLength = circumferenceLength;
    }
}
