package com.example.homework2.controller;

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

    // todo: rawCsvListをWineクラスのリストに変換する
//    List</*定義したWineクラス*/> wineList = /* Wineクラスのリスト */;


    @GetMapping("getRawCsv")
    public List<String> getRawCsv(){
        return rawCsvList;
    }


    // todo: wineListを返すエンドポイント作成する
//    @GetMapping("getWineList")
//    public List</*定義したWineクラス*/> getWineList(){
//    }

}
