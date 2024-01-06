package com.companypowernode.controller;
import com.companypowernode.service.impl.PredictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
    public class PredictionController {
        private final PredictionServiceImpl predictionService;

        @Autowired
        public PredictionController(PredictionServiceImpl predictionService) {
            this.predictionService = predictionService;
        }

        @PostMapping ("/prediction")
        public String getPrediction(String tsCode,String start_date,String end_date) throws Exception {
            return predictionService.getPredictionResult(tsCode,start_date,end_date);
        }
    }


