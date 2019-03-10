package pl.sda.spring.project.geolocationbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.spring.project.geolocationbackend.persistance.MeasurementResult;
import pl.sda.spring.project.geolocationbackend.persistance.MeasurementResultRepository;
import pl.sda.spring.project.geolocationbackend.services.GeoCodingService;
import pl.sda.spring.project.geolocationbackend.services.MeasurementResultBuilder;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    GeoCodingService geoCodingService;

    @Autowired
    MeasurementResultRepository measurementResultRepository;

    @Autowired
    MeasurementResultBuilder measurementResultBuilder;

    @GetMapping("/test")
    public MeasurementResult hello(@RequestParam("city") String cityName){
        Map<String, Double> results = geoCodingService.geocode(cityName);
        MeasurementResult measurementResult = measurementResultBuilder.build(results);
        measurementResultRepository.save(measurementResult);

        return measurementResult;
    }
}
