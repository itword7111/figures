package com.example.figures.controller;

import com.example.figures.model.CircleDto;
import com.example.figures.model.Color;
import com.example.figures.model.FigureDto;
import com.example.figures.model.RectangleDto;
import com.example.figures.service.FigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FigureController {
    private final FigureService figureService;
    @Autowired
    public FigureController(FigureService figureService) {
        this.figureService = figureService;
    }

    @RequestMapping(value = "/figures", method = RequestMethod.GET,params="c")
    public List<FigureDto> figures(@RequestParam("c") Color color) {
        return figureService.getAllFigures(color);
    }
    @RequestMapping(value = "/rectangles", method = RequestMethod.GET)
    public List<RectangleDto> rectangles() {
        return figureService.getAllRectangles();
    }
    @RequestMapping(value = "/circles", method = RequestMethod.GET)
    public List<CircleDto> circles() {
        return figureService.getAllCircles();
    }

}
