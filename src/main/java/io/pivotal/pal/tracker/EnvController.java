package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    Map retVal = new HashMap<String, String>();

    public EnvController(

            @Value("${PORT:8675}") String port,
            @Value("${MEMORY_LIMIT:12G}") String memoryLimit,
            @Value("${CF_INSTANCE_INDEX:34}") String cfInstanceIndex,
            @Value("${CF_INSTANCE_ADDR:123.sesame.street}") String cfInstanceAddr

    ) {
        /*
            "8675",
            "12G",
            "34",
            "123.sesame.street"


         */

        retVal.put("PORT", port);
        retVal.put("MEMORY_LIMIT", memoryLimit);
        retVal.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        retVal.put("CF_INSTANCE_ADDR", cfInstanceAddr);

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {


        return retVal;
    }
}
