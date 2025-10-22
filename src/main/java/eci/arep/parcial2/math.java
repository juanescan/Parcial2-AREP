package eci.arep.parcial2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class math {

    @GetMapping("/linearsearch")
    public Map<String, Object> linearSearch(@RequestParam String list, @RequestParam String value) {
        String[] inputlist = list.split(",");
        Map<String, Object> response = new HashMap<>();
        response.put("operation", "linearSearch");
        response.put("inputlist", list);
        response.put("value", value);

        for (int i = 0; i < inputlist.length; i++) {
            if (value.equals(inputlist[i])) {
                response.put("output", i);
                return response;
            }
        }
        response.put("output", -1);
        return response;
    }

}
