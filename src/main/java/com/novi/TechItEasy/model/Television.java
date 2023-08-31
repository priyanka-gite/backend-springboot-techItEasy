package com.novi.TechItEasy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Television {
    String brandName;
    String teleType;


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTeleType() {
        return teleType;
    }

    public void setTeleType(String teleType) {
        this.teleType = teleType;
    }


//    public void updateTelevision(int index, Television newTele) {
//        for (int i = 0; i < tv.size(); i++) {
//            Television t = tv.get(i);
//            if (t.getId() == index) {
//                tv.set(i, newTele);
//                return;
//            }
//        }
//    }
}

