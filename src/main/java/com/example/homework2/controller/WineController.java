package com.example.homework2.controller;

import com.example.homework2.model.Wine;
import com.example.homework2.util.LoadCsvUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wine")
public class WineController {

    private static String wineCsvPath = "src/main/resources/static/wine-1k.csv";

    // csvを読み込んで、List<String>に変換(サイズが大きいので、100件に制限)
    List<String> rawCsvList = LoadCsvUtil.convertCsvToStringList(wineCsvPath).subList(1, 101);

    List<String[]> splittedCsvList = LoadCsvUtil.splitStringList(rawCsvList);


    int WINE_INDEX_COUNTRY = 1;
    int WINE_INDEX_POINTS = 4;
    int WINE_INDEX_PRICE = 5;
    int WINE_INDEX_PROVINCE = 6;

    List<Wine> wineList = splittedCsvList.stream()
            .map(l -> new Wine(
                    l[WINE_INDEX_COUNTRY],
                    l[WINE_INDEX_POINTS],
                    l[WINE_INDEX_PRICE],
                    l[WINE_INDEX_PROVINCE])
            )
            .toList();

    /** wine-1k.csvのを文字列リストにしただけのリストを返す */
    @GetMapping("getRawCsv")
    public List<String> getRawCsv(){
        return rawCsvList;
    }

    /** wineクラスのリストを返す */
    @GetMapping("getWineList")
    public List<Wine> getWineList(){
        return wineList;
    }


}
