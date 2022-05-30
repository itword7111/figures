package com.example.figures.service;

import com.example.figures.entity.Circle;
import com.example.figures.entity.Rectangle;
import com.example.figures.model.CircleDto;
import com.example.figures.model.FigureDto;
import com.example.figures.model.RectangleDto;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    public RectangleDto mapToRectangleDto(Rectangle rectangle){
        RectangleDto rectangleDto=new RectangleDto();
        rectangleDto.setColor(rectangle.getColor());
        rectangleDto.setFirstSide(rectangle.getFirstSide());
        rectangleDto.setSecondSide(rectangle.getSecondSide());
        rectangleDto.setArea(rectangleDto.getFirstSide()*rectangleDto.getSecondSide());
        rectangleDto.setDiagonal(Math.pow(Math.pow(rectangleDto.getFirstSide(),2)+(Math.pow(rectangleDto.getSecondSide(),2)),0.5));
        rectangleDto.setPerimeter((rectangleDto.getFirstSide()+rectangleDto.getSecondSide())*2);
        return rectangleDto;
    }
    public Rectangle mapToRectangle(RectangleDto rectangleDto){
        Rectangle rectangle=new Rectangle();
        rectangle.setColor(rectangleDto.getColor());
        rectangle.setFirstSide(rectangleDto.getFirstSide());
        rectangle.setSecondSide(rectangleDto.getSecondSide());
        return rectangle;
    }
    public CircleDto mapToCircleDto(Circle circle){
        CircleDto circleDto=new CircleDto();
        circleDto.setColor(circle.getColor());
        circleDto.setRadius(circle.getRadius());
        circleDto.setArea(Math.PI*Math.pow(circleDto.getRadius(),2));
        circleDto.setCircumferenceLength(Math.PI*circleDto.getRadius()*2);
        return circleDto;
    }
    public Circle mapToCircle(CircleDto circleDto){
        Circle circle=new Circle();
        circle.setColor(circleDto.getColor());
        circle.setRadius(circleDto.getRadius());
        return circle;
    }
}
