package com.example.siki.model;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String image;

    public Category() {}

    public Category(Integer id, String name, String description, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
