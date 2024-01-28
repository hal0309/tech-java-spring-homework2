package com.example.homework2.util;

import com.example.homework2.model.Wine;

import java.util.List;

/* Wineのフィルタやソートを行うクラス */
public class WineUtil {

    public static List<Wine> sortByPoints(List<Wine> wineList) {
        return wineList.stream()
                .sorted((a, b) -> b.getPointsInt() - a.getPointsInt())
                .toList();
    }

    public static List<Wine> sortByPrice(List<Wine> wineList) {
        return wineList.stream()
                .sorted((a, b) -> (int) ((b.getPriceDouble() - a.getPriceDouble()) * 10))
                .toList();
    }

    public static List<Wine> filterByCountry(List<Wine> wineList, String country) {
        return wineList.stream()
                .filter(w -> w.country().equals(country))
                .toList();
    }
}
