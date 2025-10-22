
package eci.arep.parcial2;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class RoundRobinService {
    private static final List<String> DOMAINS = List.of(
        "http://44.215.2.215:4567/math",
        "http://98.88.111.251:4568/math"
    );
    private int currentIndex = 0;
    private final RestTemplate restTemplate = new RestTemplate();

    public JsonObject getConnection(String endpoint, String list, String value) {
        String domain = DOMAINS.get(currentIndex);
        currentIndex = (currentIndex + 1) % DOMAINS.size();
        String url = domain + endpoint + "?list=" + list + "&value=" + value;
        String result = restTemplate.getForObject(url, String.class);
        return JsonParser.parseString(result).getAsJsonObject();
    }
}