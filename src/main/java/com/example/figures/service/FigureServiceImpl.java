package com.example.figures.service;

import com.example.figures.entity.Circle;
import com.example.figures.entity.Rectangle;
import com.example.figures.model.CircleDto;
import com.example.figures.model.Color;
import com.example.figures.model.FigureDto;
import com.example.figures.model.RectangleDto;
import com.example.figures.repository.FigureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FigureServiceImpl implements FigureService {
    private final FigureRepository figureRepository;
    private final MappingUtils mappingUtils;
@Autowired
    public FigureServiceImpl(FigureRepository figureRepository, MappingUtils mappingUtils) {
        this.figureRepository = figureRepository;
        this.mappingUtils = mappingUtils;
    }

    @Override
    public List<FigureDto> getAllFigures(Color color) {
        List<Rectangle> rectangleList = new LinkedList<>();
        List<Circle> circleList = new LinkedList<>();
        if (color == null) {
            rectangleList = figureRepository.getAllRectangles();
            circleList = figureRepository.getAllCircles();
        } else {
            rectangleList = figureRepository.getAllRectanglesByColor(color);
            circleList = figureRepository.getAllCirclesByColor(color);
        }
        List<RectangleDto> rectangleListDto = rectangleList.stream()
                .map(mappingUtils::mapToRectangleDto)
                .collect(Collectors.toList());
        List<CircleDto> circleListDto = circleList.stream()
                .map(mappingUtils::mapToCircleDto)
                .collect(Collectors.toList());
        List<FigureDto> figureDto = new LinkedList<>();
        figureDto.addAll(circleListDto);
        figureDto.addAll(rectangleListDto);

        return figureDto.stream().sorted((x, y) -> x.getArea().compareTo(y.getArea())).collect(Collectors.toList());
    }

    @Override
    public void setCircles(List<Circle> circles) {
        figureRepository.setCircles(circles);
    }

    @Override
    public void setRectangles(List<Rectangle> rectangle) {
        figureRepository.setRectangles(rectangle);
    }

    @Override
    public List<RectangleDto> getAllRectangles() {
        return figureRepository.getAllRectangles().stream()
                .map(mappingUtils::mapToRectangleDto)
                .sorted((x, y) -> x.getDiagonal().compareTo(y.getDiagonal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CircleDto> getAllCircles() {
        return figureRepository.getAllCircles().stream()
                .map(mappingUtils::mapToCircleDto)
                .sorted((x, y) -> x.getRadius().compareTo(y.getRadius()))
                .collect(Collectors.toList());
    }
}
