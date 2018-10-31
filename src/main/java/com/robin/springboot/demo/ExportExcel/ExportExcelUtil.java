package com.robin.springboot.demo.ExportExcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportExcelUtil {
    /**
     * @param sheetName     分表名称
     * @param columnNames   表头名列表
     * @param sheetData     表格数据
     * @param excelFilePath excel表格保存路径
     */
    public static void writeExcel(String sheetName, List<String> columnNames, List<List<String>> sheetData, String excelFilePath) {
        // 建立一个Excel
        Workbook book = new HSSFWorkbook();
        // 在对应的Excel中建立一个分表
        Sheet sheet = book.createSheet(sheetName);
        writeData2ExcelSheet(book, sheet, columnNames, sheetData);
        // 保存到计算机相应路径
        try {
            book.write(new FileOutputStream(excelFilePath));
        } catch (IOException e) {
            System.out.println("写入数据错误");
            e.printStackTrace();
        }
    }

    private static void writeData2ExcelSheet(Workbook book, Sheet sheet, List<String> columnNames, List<List<String>> sheetData) {
        if (null == columnNames || columnNames.size() < 0) {
            System.out.println("列名不能为空");
            return;
        }
        // 表格列数
        int columnNum = columnNames.size();
        System.out.println("列数：" + columnNum);
        // 设置表头（初始从0开始）
        Row row = sheet.createRow(0);
        for (int i = 0; i < columnNum; i++) {
            // 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
            Cell cell = row.createCell(i);
            // 写入相关数据到设置的行列中去。
            cell.setCellValue(columnNames.get(i));
        }
        for (int i = 0; i < sheetData.size(); i++) {
            Row rowTemp = sheet.createRow(i + 1);
            List<String> data = sheetData.get(i);
            for (int j = 0; j < data.size(); j++) {
                // 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
                Cell cell = rowTemp.createCell(j);
                // 写入相关数据到设置的行列中去。
                cell.setCellValue(data.get(j));
                if (isNumeric(data.get(j)) && Integer.parseInt(data.get(j)) > 0) {
                    CellStyle style = book.createCellStyle();
                    style.setFillForegroundColor(IndexedColors.RED.getIndex());
                    style.setFillPattern((short) 1);
                    cell.setCellStyle(style);
                }
            }
        }
    }

    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        } else {
            return true;
        }
    }

}
