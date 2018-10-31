package com.robin.springboot.demo.java_ExportExcel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ExcelPrase {
    public static void main(String[] args) {
        ExcelPrase ex = new ExcelPrase();
        String fileName = "tp0.01 0.960.sif";
        String pathName = "F:\\曲正\\" + fileName + ".txt";
        String excelPathName = "F:\\曲正\\" + fileName + ".xls";

        ex.deal(fileName, pathName, excelPathName);
    }

    private void deal(String fileName, String pathName, String excelPathName) {
        List<Model> all = parseTxt(pathName);
        getExcelData(all, excelPathName, fileName);
    }

    // 从文件中获取数据，建立模型
    private List<Model> parseTxt(String pathName) {
        List<Model> all = new ArrayList<>();
        try {
            File file = new File(pathName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while (line != null) {
                line = br.readLine();
                if (null == line) continue;
                Model m1 = dealLineTxt(line);
                if (null != m1) all.add(m1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    private Model dealLineTxt(String lineTxt) {
        Model m1 = new Model();
        String splistStr;
        if (lineTxt.indexOf("\tnp\t") > 0) {
            splistStr = "\tnp\t";
        } else if (lineTxt.indexOf("\tpp\t") > 0) {
            splistStr = "\tpp\t";
        } else {
            return null;
        }

        String[] a = lineTxt.split(splistStr);
        for (int i = 0; i < a.length; i++) {
            if (0 == i) m1.setS1(a[i]);
            if (1 == i) m1.setS2(a[i]);
        }
        return m1;
    }

    // 解析数组
    private void getExcelData(List<Model> all, String excelFilePath, String sheetName) {
        // 获取所有项目，不重复
        HashSet<String> allItems = new HashSet();
        for (Model m : all) {
            allItems.add(m.getS1());
            allItems.add(m.getS2());
        }

        List<String> colnumName = new ArrayList<>();
        colnumName.add("");

        List<List<String>> allMap = new ArrayList<>();
        for (Iterator it = allItems.iterator(); it.hasNext(); ) {
            String s = (String) it.next();
            colnumName.add(s);
            List<String> temp = new ArrayList<>();
            temp.add(s);
            for (Iterator it2 = allItems.iterator(); it2.hasNext(); ) {
                String s2 = (String) it2.next();
                Model m1 = new Model(s, s2);
                Model m2 = new Model(s2, s);
                if (all.indexOf(m1) > -1 || all.indexOf(m2) > -1) {
                    temp.add(1 + "");
                } else {
                    temp.add(0 + "");
                }
            }
            allMap.add(temp);
        }
        System.out.println("行数：" + allMap.size());
        ExportExcelUtil.writeExcel(sheetName, colnumName, allMap, excelFilePath);
    }

}


