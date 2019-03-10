package pl.sda.spring.project.geolocationbackend.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class MeasurementResult {
    @Id
    @GeneratedValue
    private Long id;
    private Double pressure;
    private Double humidity;
    private Double temperature;
    private Double pm1;
    private Double pm25;
    private Double pm10;

    public MeasurementResult() {
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPm1() {
        return pm1;
    }

    public void setPm1(Double pm1) {
        this.pm1 = pm1;
    }

    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }
}
