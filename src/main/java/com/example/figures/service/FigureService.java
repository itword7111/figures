package com.example.figures.service;

import com.example.figures.entity.Circle;
import com.example.figures.entity.Rectangle;
import com.example.figures.model.CircleDto;
import com.example.figures.model.Color;
import com.example.figures.model.FigureDto;
import com.example.figures.model.RectangleDto;

import java.util.List;

public interface FigureService {
    public List<FigureDto> getAllFigures(Color color);
    public void setCircles(List<Circle> circles);
    public void setRectangles(List<Rectangle> rectangle);
    public List<RectangleDto> getAllRectangles();
    public List<CircleDto> getAllCircles();
}
