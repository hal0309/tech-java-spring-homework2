package com.example.homework2.controller;

import com.example.homework2.model.Beer;
import com.example.homework2.util.LoadCsvUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.example.homework2.util.BeerUtil.*;

@RestController
@RequestMapping("beer")
public class BeerController {

    private static String beerCsvPath = "src/main/resources/static/beer.csv";

    // csvを読み込んで、List<String>に変換(サイズが大きいので、100件に制限)
    List<String> rawCsvList = LoadCsvUtil.convertCsvToStringList(beerCsvPath).subList(1, 101);
    List<String[]> splittedCsvList = LoadCsvUtil.splitStringList(rawCsvList);

    int BEER_INDEX_COUNTRY = 1;
    int BEER_INDEX_POINTS = 2;
    int BEER_INDEX_PRICE = 3;
    int BEER_INDEX_PROVINCE = 4;

    List<Beer> beerList = splittedCsvList.stream()
            .map(l -> new Beer(
                    l[BEER_INDEX_COUNTRY],
                    l[BEER_INDEX_POINTS],
                    l[BEER_INDEX_PRICE],
                    l[BEER_INDEX_PROVINCE])
            )
            .toList();


    /** beer.csvのを文字列リストにしただけのリストを返す */
    @GetMapping("getRawCsv")
    public List<String> getRawCsv(){
        return rawCsvList;
    }

    /** beerクラスのリストを返す(ソート・フィルタ機能付き) */
    @GetMapping("getBeerList")
    public List<Beer> getBeerList(
            @RequestBody(required = false) Map<String, String> body
    ){

        if(body == null){
            return beerList;
        }

        // 元のbeerListに影響を与えないように、beerListをコピー
        List<Beer> beerList = this.beerList;

        // bodyにcountryが含まれている場合、countryでフィルタ
        if(body.containsKey("country")){
            beerList = filterByCountry(beerList, body.get("country"));
        }

        // bodyにsortが含まれている場合、sortでソート
        if(body.containsKey("sort")){
            beerList = switch (body.get("sort")) {
                case "points" -> sortByPoints(beerList);
                case "price" -> sortByPrice(beerList);
                default -> throw new IllegalArgumentException("sortの値が不正です");
            };
        }

        return beerList;
    }

}
