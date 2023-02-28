package com.tws.tws.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Getter
@Setter
@NoArgsConstructor
public class DocumentDTO {

    private int documentId;
    private String strIS = "test IS";
    public InputStream is;
    private byte[] document;

    public void createInputStream(){
        is = new ByteArrayInputStream(strIS.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] getDocumentByID(String id) throws IOException {
        createInputStream();
        switch (id) {
            case "1":
                return is.toString().getBytes(StandardCharsets.UTF_8);
            default: return  null;
        }
    }
}
