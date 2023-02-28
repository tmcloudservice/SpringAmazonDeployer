package com.tws.tws.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchDTO {

    //TODO make the search DTO field to contain stringbuilder or stringbuffer instead of simple String object;
    private String searchContent;

    //TODO make DB connection and return object and pagination

}
