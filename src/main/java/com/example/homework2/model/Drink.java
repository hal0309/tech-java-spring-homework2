package com.example.homework2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Drink{

    public String country;
    public String points;
    public String price;
    public String province;

    public Drink(String country, String points, String price, String province){
        this.country = country;
        this.points = points;
        this.price = price;
        this.province = province;
    }

    /* もとのフィールド変数countryがpublicなので不要ですが解説用です */
    public String country(){
        return country;
    }

    /** pointsをintに変換して返す(数値では無い場合0を返す) */
    @JsonIgnore
    public int getPointsInt(){
        int pointsInt;
        try {
            pointsInt = Integer.parseInt(points);
        } catch (NumberFormatException e) {
            pointsInt = 0;
        }
        return pointsInt;
    }

    /** priceをintに変換して返す(数値では無い場合0を返す) */
    @JsonIgnore
    public Double getPriceDouble(){
        double priceDouble;
        try {
            priceDouble = Double.parseDouble(price);
        } catch (NumberFormatException e) {
            priceDouble = 0d;
        }
        return priceDouble;
    }
}
