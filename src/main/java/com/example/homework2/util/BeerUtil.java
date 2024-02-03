package com.example.homework2.util;

import com.example.homework2.model.Beer;

import java.util.List;

/* Beerのフィルタやソートを行うクラス */
public class BeerUtil {

    public static List<Beer> sortByPoints(List<Beer> wineList) {
        return wineList.stream()
                .sorted((a, b) -> b.getPointsInt() - a.getPointsInt())
                .toList();
    }

    public static List<Beer> sortByPrice(List<Beer> wineList) {
        return wineList.stream()
                .sorted((a, b) -> (int) ((b.getPriceDouble() - a.getPriceDouble()) * 10))
                .toList();
    }

    public static List<Beer> filterByCountry(List<Beer> wineList, String country) {
        return wineList.stream()
                .filter(w -> w.country().equals(country))
                .toList();
    }
}
