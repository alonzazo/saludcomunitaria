package com.oazofeifa.tcudrake.Persistence.Entities;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileFormBean {

    CommonsMultipartFile imageEntry;

    public CommonsMultipartFile getImageEntry() {
        return imageEntry;
    }

    public void setImageEntry(CommonsMultipartFile imageEntry) {
        this.imageEntry = imageEntry;
    }
}
