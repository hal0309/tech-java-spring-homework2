package com.example.homework2.model;

public record Wine(
        String country,
        String points,
        String price,
        String province
){
    /** pointsをintに変換して返す(数値では無い場合0を返す) */
    public int getPointsInt(){
        int pointsInt;
        try {
            pointsInt = Integer.parseInt(points);
        } catch (NumberFormatException e) {
            pointsInt = 0;
        }
        return pointsInt;
    }


    //todo: 適宜メソッドを追加
}
