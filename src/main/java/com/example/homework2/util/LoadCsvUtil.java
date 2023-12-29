package com.example.homework2.util;

import com.example.homework2.model.Wine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadCsvUtil {

    static final String REGEX_CSV_COMMA = ",(?=(([^\"]*\"){2})*[^\"]*$)";

    static final String REGEX_SURROUND_DOUBLEQUATATION = "^\"|\"$";

    static final String REGEX_DOUBLEQUOATATION = "\"\"";

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

    public static List<String[]> splitStringList(List<String> stringList){
        List<String[]> result = new ArrayList<>();
        for(String l : stringList){
            result.add(splitLineWithComma(l));
        }
        return result;
    }

    public static List<Wine> convertWine(List<String[]> stringList){
        List<Wine> result = new ArrayList<>();
        for(String[] l : stringList){
            Wine wine = new Wine(l[1],l[4],l[5],l[6]);
            result.add(wine);
        }
        return result;
    }

    private static String[] splitLineWithComma(String line) {
        // 分割後の文字列配列
        String[] arr = null;

        try {
            // 「"」で囲まれていない「,」で行を分割する。
            Pattern cPattern = Pattern.compile(REGEX_CSV_COMMA);
            String[] cols = cPattern.split(line, -1);

            arr = new String[cols.length];
            for (int i = 0, len = cols.length; i < len; i++) {
                String col = cols[i].trim();

                // 最初と最後に「"」があれば削除する。
                Pattern sdqPattern =
                        Pattern.compile(REGEX_SURROUND_DOUBLEQUATATION);
                Matcher matcher = sdqPattern.matcher(col);
                col = matcher.replaceAll("");

                // エスケープされた「"」を戻す。
                Pattern dqPattern =
                        Pattern.compile(REGEX_DOUBLEQUOATATION);
                matcher = dqPattern.matcher(col);
                col = matcher.replaceAll("\"");

                arr[i] = col;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }


}
