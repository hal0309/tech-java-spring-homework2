package com.example.homework2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Beer extends Drink {

    public Beer(String country, String points, String price, String province){
        super(country, points, price, province);
    }
}
