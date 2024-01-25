package com.example.homework2.controller;

import com.example.homework2.model.Wine;
import com.example.homework2.util.LoadCsvUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.example.homework2.util.WineUtil.*;

@RestController
@RequestMapping("beer")
public class BeerController {

    private static String beerCsvPath = "src/main/resources/static/beer.csv";

    // csvを読み込んで、List<String>に変換(サイズが大きいので、100件に制限)
    List<String> rawCsvList = LoadCsvUtil.convertCsvToStringList(beerCsvPath).subList(1, 101);


    /** wine-1k.csvのを文字列リストにしただけのリストを返す */
    @GetMapping("getRawCsv")
    public List<String> getRawCsv(){
        return rawCsvList;
    }

}
