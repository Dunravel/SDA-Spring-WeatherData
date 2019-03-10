package pl.sda.spring.project.geolocationbackend.persistance;

import org.springframework.data.repository.CrudRepository;

public interface MeasurementResultRepository extends CrudRepository<MeasurementResult, Long> {
}
