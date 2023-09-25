package com.novi.TechItEasy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "remote-controls")
public class RemoteControl {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "compatible_with")
    private String compatibleWith;

    @Column(name = "battery_type")
    private  String batteryType;

    @Column(name = "brand")
    private String brand ;

    @Column(name = "price")
    private Double price;

    @Column(name = "original_stock")
    private Integer originalStock;

//    making the television as the owner by referring to the value of "mapped by" by pointing to the name of the variable located in the owner
    @OneToOne(mappedBy = "remoteControl")
    private Television television;

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
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

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }
}
