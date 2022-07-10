package com.example.figures.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseSetup {
    @Autowired
    private FigureRepository figureRepository;
    @PostConstruct
    public void init() {
        figureRepository.init();
    }
}
