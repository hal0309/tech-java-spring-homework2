package com.example.homework2.controller;

import com.example.homework2.model.Wine;
import com.example.homework2.util.LoadCsvUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.example.homework2.util.WineUtil.*;

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

    /** wineクラスのリストを返す(ソート・フィルタ機能付き) */
    @GetMapping("getWineList")
    public List<Wine> getWineList(
            @RequestBody Map<String, String> body
    ){
        // 元のwineListに影響を与えないように、wineListをコピー
        List<Wine> wineList = this.wineList;

        // bodyにcountryが含まれている場合、countryでフィルタ
        if(body.containsKey("country")){
            wineList = filterByCountry(wineList, body.get("country"));
        }

        // bodyにsortが含まれている場合、sortでソート
        if(body.containsKey("sort")){
            wineList = switch (body.get("sort")) {
                case "points" -> sortByPoints(wineList);
                case "price" -> sortByPrice(wineList);
                default -> wineList;
            };
        }

        return wineList;
    }
}
