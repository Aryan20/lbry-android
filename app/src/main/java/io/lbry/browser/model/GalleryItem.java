package com.aryan.lbrybrowser.model;

import lombok.Data;

@Data
public class GalleryItem {
    private String id;
    private String name;
    private String filePath;
    private String type;
    private String thumbnailPath;
    private long duration;
}
