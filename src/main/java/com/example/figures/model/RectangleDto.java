package com.example.figures.model;

public class RectangleDto implements FigureDto {
    private Double firstSide;
    private Double secondSide;
    private String color;
    private Double diagonal;
    private Double area;
    private Double perimeter;

    public RectangleDto() {
    }

    public RectangleDto(Double firstSide, Double secondSide, String color, Double diagonal, Double area, Double perimeter) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.color = color;
        this.diagonal = diagonal;
        this.area = area;
        this.perimeter = perimeter;
    }

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

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }
}
