package pl.sda.spring.project.geolocationbackend.services;

import org.springframework.stereotype.Service;
import pl.sda.spring.project.geolocationbackend.persistance.MeasurementResult;

import java.util.Map;

@Service
public class MeasurementResultBuilder {
    public MeasurementResult build(Map<String,Double> sourceData){
        MeasurementResult measurementResult = new MeasurementResult();
        measurementResult.setPressure(sourceData.get("PRESSURE"));
        measurementResult.setTemperature(sourceData.get("TEMPERATURE"));
        measurementResult.setHumidity(sourceData.get("HUMIDITY"));
        measurementResult.setPm1(sourceData.get("PM1"));
        measurementResult.setPm10(sourceData.get("PM10"));
        measurementResult.setPm25(sourceData.get("PM25"));

        return measurementResult;
    }
}
