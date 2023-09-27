package com.novi.TechItEasy.dto;

import com.novi.TechItEasy.model.Television;

import java.util.List;

public class CiModuleDto {

    private Long id;

    private String name;
    
    private String type;

    private Double price;

    private List<Television> televisions;

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
