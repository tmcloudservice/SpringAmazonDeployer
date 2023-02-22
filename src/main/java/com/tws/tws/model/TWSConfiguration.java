package com.tws.tws.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static java.nio.charset.Charset.defaultCharset;

@Getter
@Setter
@NoArgsConstructor
public class TWSConfiguration {

    private int id;
    private String configurationName;
    private String appName;
    private long appSizeInMB;

    public void readConfiguration() throws IOException {
        InputStream is = TypeReference.class.getResourceAsStream("/app_config/appconfig.conf");
        String resource = StreamUtils.copyToString(
                new ClassPathResource("/app_config/appconfig.conf").getInputStream(), defaultCharset());

        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .modulesToInstall(new Class[]{String.class})
                .build();

        objectMapper = Jackson2ObjectMapperBuilder.json().serializationInclusion(JsonInclude.Include.NON_EMPTY).build();

        //TODO resource.split("\r\n")[0].split(":") split all configuration into JSON object and expose
        //the different json fields
        

    }


}
