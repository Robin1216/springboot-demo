package com.robin.springboot.demo.java_ExportExcel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TextPrase {
    public static void main(String[] args) {
        String fileName = "20140409";
        String pathName = "F:\\test\\" + fileName + ".txt";
        String excelPathName = "F:\\test\\result_" + fileName + ".xlsx";

        TextPrase textPrase = new TextPrase();
        textPrase.deal(fileName, pathName, excelPathName);
    }

    private void deal(String fileName, String pathName, String excelPathName) {
        LinkedHashSet<Model> all = parseTxt(pathName);
        getExcelData(all, excelPathName, fileName);
    }

    // 从文件中获取数据，建立模型
    private LinkedHashSet<Model> parseTxt(String pathName) {
        LinkedHashSet<Model> all = new LinkedHashSet<>();
        try {
            File file = new File(pathName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while (line != null) {
                line = br.readLine();
                if (null == line) continue;
                LinkedHashSet<Model> m1 = dealLineTxt(line);
                if (null != m1) all.addAll(m1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    private LinkedHashSet<Model> dealLineTxt(String lineTxt) {
        String splitStr = "\t";
        String[] a = lineTxt.split(splitStr);
        if (a.length < 2) {
            return null;
        }
        LinkedHashSet<Model> result = new LinkedHashSet<>();

        String s1 = a[0];
        for (int i = 1; i < a.length; i++) {
            String s2 = a[i];
            if ("NA".equals(s2)) {
                continue;
            }

            Model m1 = new Model();
            m1.setS1(s1);
            m1.setS2(s2);
            result.add(m1);
        }
        return result;
    }

    // 解析数组,导出数据
    private void getExcelData(LinkedHashSet<Model> all, String excelFilePath, String sheetName) {
        List<String> columnNames = new ArrayList<>();
        columnNames.add("列1");
        columnNames.add("列2");

        List<List<String>> allMap = new ArrayList<>();
        for(Model model : all){
            List<String> lineTxt = new ArrayList<>();
            lineTxt.add(model.getS1());
            lineTxt.add(model.getS2());

            allMap.add(lineTxt);
        }

        System.out.println("行数：" + allMap.size());
        ExportExcelUtil.writeExcelForXlsx(sheetName, columnNames, allMap, excelFilePath);
    }


}
