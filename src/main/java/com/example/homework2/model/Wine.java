package com.example.homework2.model;



/**
 * Wineオブジェクト
 *
 * @param country  国
 * @param points 評価点数(1～100)
 * @param price 価格(米ドル)
 * @param province 県または州
 */
public record Wine(String country, String points, String price, String province) {

}

//public class Wine {
//    public String country;
//
//    public String points;
//
//    public String price;
//
//    public String province;
//
//    public Wine(String country, String points, String price, String province) {
//        this.country = country;
//        this.points = points;
//        this.price = price;
//        this.province = province;
//    }
//}