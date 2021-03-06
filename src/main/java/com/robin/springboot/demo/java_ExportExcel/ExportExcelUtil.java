package com.robin.springboot.demo.java_ExportExcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
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
            System.out.println("excelFilePath" + excelFilePath);
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
        int colNo = 0;
        for (int i = 0; i < columnNum; i++) {
            int firstRow = colNo;
            int lastRow = colNo + 1;

            CellRangeAddress region = new CellRangeAddress(0, 0, firstRow, lastRow);
            sheet.addMergedRegion(region);
            // 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
            Cell cell = row.createCell(firstRow);
            // 写入相关数据到设置的行列中去。
            cell.setCellValue(columnNames.get(i));
            colNo = lastRow + 1;
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

    public static void writeExcelForXlsx(String sheetName, List<String> columnNames, List<List<String>> sheetData, String excelFilePath) {
        // 建立一个Excel
        XSSFWorkbook book = new XSSFWorkbook();
        // 在对应的Excel中建立一个分表
        XSSFSheet sheet = book.createSheet(sheetName);
        writeData2ExcelSheetForXslx(book, sheet, columnNames, sheetData);
        // 保存到计算机相应路径
        try {
            book.write(new FileOutputStream(excelFilePath));
            System.out.println("excelFilePath" + excelFilePath);
        } catch (IOException e) {
            System.out.println("写入数据错误");
            e.printStackTrace();
        }
    }

    private static void writeData2ExcelSheetForXslx(XSSFWorkbook book, XSSFSheet sheet, List<String> columnNames, List<List<String>> sheetData) {
        if (null == columnNames || columnNames.size() < 0) {
            System.out.println("列名不能为空");
            return;
        }
        // 表格列数
        int columnNum = columnNames.size();
        System.out.println("列数：" + columnNum);
        // 设置表头（初始从0开始）
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < columnNum; i++) {
            // 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
            XSSFCell cell = row.createCell(i);
            // 写入相关数据到设置的行列中去。
            cell.setCellValue(columnNames.get(i));
        }
        for (int i = 0; i < sheetData.size(); i++) {
            XSSFRow rowTemp = sheet.createRow(i + 1);
            List<String> data = sheetData.get(i);
            for (int j = 0; j < data.size(); j++) {
                // 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
                XSSFCell cell = rowTemp.createCell(j);
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

    public static void main(String[] args) {
        String sheetName = "测试";
        List<String> columnNames = new ArrayList<>();
        columnNames.add("合并1");
        columnNames.add("合并2");
        columnNames.add("合并3");

        List<List<String>> sheetData = new ArrayList<>();
        List<String> rowData = new ArrayList<>();
        rowData.add("1");
        rowData.add("2");
        sheetData.add(rowData);

        String excelFilePath = "D:\\Downloads\\test.xls";
        writeExcel(sheetName, columnNames, sheetData, excelFilePath);
    }
}
