package com.example.homework2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

public class Wine extends Drink{

    public Wine(String country, String points, String price, String province) {
        super(country,points,price,province);
    }
}
