package com.example.homework2.util;

import com.example.homework2.model.Beer;
import com.example.homework2.model.Wine;

import java.util.List;

/* Wineのフィルタやソートを行うクラス */
public class BeerUtil {

    public static List<Beer> sortByPoints(List<Beer> beerList) {
        return beerList.stream()
                .sorted((a, b) -> b.getPointsInt() - a.getPointsInt())
                .toList();
    }

    public static List<Beer> sortByPrice(List<Beer> beerList) {
        return beerList.stream()
                .sorted((a, b) -> (int) ((b.getPriceDouble() - a.getPriceDouble()) * 10))
                .toList();
    }

    public static List<Beer> filterByCountry(List<Beer> beerList, String country) {
        return beerList.stream()
                .filter(w -> w.country().equals(country))
                .toList();
    }
}
