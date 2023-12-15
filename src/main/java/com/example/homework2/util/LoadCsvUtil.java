package com.example.homework2.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoadCsvUtil {

    public static List<String[]> splitStringList(List<String> stringList){
        List<String[]> result = new ArrayList<>();
        for(String l : stringList){
            result.add(l.split(","));
        }
        return result;
    }

    public static List<String> convertCsvToStringList(String resourcePath){
        List<String> lines;
        try{
            Path filePath = Paths.get(resourcePath);
            lines = Files.readAllLines(filePath);
        }catch(IOException e){
            System.err.println("csvの読み込みに失敗(内容は以下)");
            System.err.println(e);
            lines = new ArrayList<>();
        }
        return lines;
    }
}
