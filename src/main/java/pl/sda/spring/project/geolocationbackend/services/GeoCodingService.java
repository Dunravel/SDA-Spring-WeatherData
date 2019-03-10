package pl.sda.spring.project.geolocationbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.spring.project.geolocationbackend.persistance.MeasurementResult;

import java.util.*;

@Service
public class GeoCodingService {

    @Value("${geocoding.url}")
    private String url;

    @Value("${geocoding.key}")
    private String key;

    @Autowired
    RestTemplate restTemplate;



    public Map<String,Double> geocode(String cityName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey",key);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String stations = "v2/measurements/installation?installationId=204";
        String request = url + stations;
        System.out.println(request);
        ResponseEntity<Map> exchange = restTemplate.exchange(request, HttpMethod.GET, entity, Map.class);
        //System.out.println(exchange.getBody().toString());

        List tempResult = ((List)((Map)exchange.getBody().get("current")).get("values"));
        Iterator<Map> tempIterator = tempResult.iterator();

        List<String> values = new ArrayList<>();
        while (tempIterator.hasNext()){
            Map map = tempIterator.next();
            Iterator<Map.Entry<String,Object>> entryIterator = map.entrySet().iterator();
            while(entryIterator.hasNext()) {
                Map.Entry<String, Object> next = entryIterator.next();
                values.add(next.getValue().toString());
            }
        }

        Map<String,Double> result = new HashMap<>();
        for(int i = 0; i < values.size() - 1; i+=2 ){
            result.put(values.get(i),Double.parseDouble(values.get((i+1))));
        }

        return result;
    }
}
