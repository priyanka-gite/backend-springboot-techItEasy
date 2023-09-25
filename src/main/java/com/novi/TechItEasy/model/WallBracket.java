package com.novi.TechItEasy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "wall_brackets")

public class WallBracket {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "size")
    private String size;

    @Column(name = "adjustable")
    private Boolean adjustable;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
