package com.example.figures.repository;

import com.example.figures.entity.Circle;
import com.example.figures.entity.Rectangle;
import com.example.figures.model.Color;

import java.util.List;

public interface FigureRepository {
    public List<Circle> getAllCircles();
    public List<Rectangle> getAllRectangles();
    public List<Circle> getAllCirclesByColor(Color color);
    public List<Rectangle> getAllRectanglesByColor(Color color);
    public void setCircles(List<Circle> circles);
    public void setRectangles(List<Rectangle> rectangles);
    public void init();
}
