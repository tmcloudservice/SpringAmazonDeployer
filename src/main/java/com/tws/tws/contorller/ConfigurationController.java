package com.tws.tws.contorller;

import com.tws.tws.model.TWSConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ConfigurationController {


    @GetMapping("/configuration")
    public TWSConfiguration getProjectConfiguration() throws IOException {
        TWSConfiguration configuration = new TWSConfiguration();
        configuration.readConfiguration();
        return configuration;
    }

}
