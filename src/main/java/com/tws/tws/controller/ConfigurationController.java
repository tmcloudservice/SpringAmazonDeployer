package com.tws.tws.contorller;

import com.tws.tws.model.DocumentDTO;
import com.tws.tws.model.MenuDTO;
import com.tws.tws.model.SearchDTO;
import com.tws.tws.model.TWSConfiguration;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ConfigurationController {


    @GetMapping("/configuration")
    public TWSConfiguration getProjectConfiguration() throws IOException {
        TWSConfiguration configuration = new TWSConfiguration();
        configuration.readConfiguration();
        return configuration;
    }

    @GetMapping("/menu")
    @ResponseBody
    //TODO Put here the request from the front end
    public MenuDTO getTWSMenu() throws IOException {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setHome("Home");
        menuDTO.setProfile("Profile");
        menuDTO.setService("Services");
        menuDTO.setSupport("Support");
        menuDTO.setMore("More");

        return menuDTO;
    }

    @PostMapping("/search")
    public SearchDTO webSearch(@RequestBody  SearchDTO searchDTONew) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setSearchContent(searchDTONew.getSearchContent());
        return searchDTO;
    }

    @PostMapping("/downloadDocs")
    public byte[] downloadFromTheServer(@RequestBody  DocumentDTO documentId) throws IOException {
       DocumentDTO searchDTO = new DocumentDTO();
        return searchDTO.getDocumentByID(String.valueOf(documentId.getDocumentId()));
    }
}
