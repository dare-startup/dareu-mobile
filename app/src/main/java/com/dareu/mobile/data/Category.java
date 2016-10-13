package com.dareu.mobile.data;

/**
 * Created by jose.rubalcaba on 10/12/2016.
 */

public class Category extends DareuEntity{
    private String name;
    private String description;

    public Category() {
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

    public void setDescription(String description) {
        this.description = description;
    }
}