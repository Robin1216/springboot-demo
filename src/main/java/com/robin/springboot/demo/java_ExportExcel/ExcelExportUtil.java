package com.robin.springboot.demo.java_ExportExcel;


//import com.google.common.base.Predicates;
//import com.verse.hades.core.constant.ResultCodeConstant;
//import com.verse.hades.core.exception.BusinessException;
//import com.verse.hades.excel.annotaion.ExcelNum;
//import com.verse.hades.excel.annotaion.ExcelPercent;
//import com.verse.hades.excel.annotaion.ExcelUnit;
//import com.verse.hades.utils.LocalDateUtil;
//import com.verse.hades.utils.MoneyUtil;
//import com.verse.hades.utils.ReflectionHelper;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.reflections.ReflectionUtils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.*;
//
/**
 * @author silkNets
 * @program springboot-demo
 * @description 导出合并单元格
 * @createDate 2019-08-23 12:03
 */
// 参考 https://www.cnblogs.com/JoeyWong/p/11096927.html
public class ExcelExportUtil {
//    public static final String HEADNAME = "headName";  //列名 key的值
//
//    public static final String HEADNUM = "headNum";     //合并单元格下标 key的值
//
//    /**
//     * @param: sheetName
//     * @param: objList 导出的数据对象列表
//     * @param: attr 导出数据对象对应的字段
//     * @param: headMap 头部列表名称数组与合并单元格数组的Map
//     * @param: clazz 对象类
//     * @Return: org.apache.poi.ss.usermodel.Workbook
//     * @Decription:
//     * @Modify:
//     */
//    public static <T> Workbook exportMergeXls(String sheetName, List<T> objList, List<String> attr, Map<Integer/*行标*/,
//            Map<String/*头部列表key的名字*/, String[]/*对应的值*/>> headMap, Class<T> clazz) {
//        //String[] head0, String[] headnum0, String[] head1, String[] headnum1,
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet(sheetName);
//
//        //头部单元格样式
//        CellStyle cellStyle = workbook.createCellStyle();
//        setAlign(cellStyle, HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
//        setBorder(cellStyle, BorderStyle.THIN, IndexedColors.BLACK);
//        setColor(cellStyle, IndexedColors.GREY_25_PERCENT.index, FillPatternType.SOLID_FOREGROUND);
//
//        Font font = workbook.createFont();
//        font.setFontName("Arial");
//        font.setFontHeightInPoints((short) 10);//设置字体大小
//        cellStyle.setFont(font);
//
//        Set<Integer> headKeySet = headMap.keySet();
//        if (headKeySet.size() > 0) {
//            headKeySet.stream().sorted();
//            for (Integer rowNum : headKeySet) {
//                Map<String, String[]> rowInfo = headMap.get(rowNum);
//                String[] headName = rowInfo.get(HEADNAME);
//                String[] headNum = rowInfo.get(HEADNUM);
//
//                if (null != headName && headName.length > 0) {
//                    Row row1 = sheet.createRow(rowNum);
//                    for (int i = 0; i < headName.length; i++) {
//                        Cell cell = row1.createCell(i);
//                        cell.setCellValue(headName[i]);
//                        cell.setCellStyle(cellStyle);
//                    }
//                }
//
//                if (null != headNum && headNum.length > 0) {
//                    //动态合并单元格
//                    for (String aHeadNum : headNum) {
//                        String[] temp = aHeadNum.split(",");
//                        Integer startrow = Integer.parseInt(temp[0]);
//                        Integer overrow = Integer.parseInt(temp[1]);
//                        Integer startcol = Integer.parseInt(temp[2]);
//                        Integer overcol = Integer.parseInt(temp[3]);
//                        CellRangeAddress cra = new CellRangeAddress(startrow, overrow, startcol, overcol);
//                        sheet.addMergedRegion(cra);
//                    }
//                }
//            }
//        }
//
//        return insertData(workbook, sheet, objList, clazz, attr, headKeySet.size(), attr.size());
//    }
//
//    /**
//     * @param: workbook
//     * @param: sheet
//     * @param: objList  对象列表
//     * @param: clazz 对象类
//     * @param: attr  对象的字段名数组
//     * @param: startRow  数据开始的行数
//     * @param: colNum 总共的列数
//     * @Return: org.apache.poi.ss.usermodel.Workbook
//     * @Decription: 插入数据
//     * @Modify:
//     */
//    private static <T> Workbook insertData(Workbook workbook, Sheet sheet, List<T> objList, Class<T> clazz, List<String> attr, int startRow, int colNum) {
//        CellStyle cellStyle = workbook.createCellStyle();
//        setAlign(cellStyle, HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
//        setBorder(cellStyle, BorderStyle.THIN, IndexedColors.BLACK);
//        Font font = workbook.createFont();
//        font.setFontName("Arial");
//        font.setFontHeightInPoints((short) 10);//设置字体大小
//        cellStyle.setFont(font);
//
//        List<List<Object>> lists = getValueList(objList, clazz, attr);
//
//        for (List<Object> list : lists) {
//            Row row = sheet.createRow(startRow++);
//            for (int col = 0; col < colNum; col++) {
//                Cell cell = row.createCell(col);
//
//                //设置单元格换行
//                cell.setCellStyle(cellStyle);
//
//                writeCell(workbook, list.get(col), cell);
//            }
//        }
//        return workbook;
//    }
//
//    /**
//     * @param: workbook
//     * @param: obj
//     * @param: cell
//     * @Return: void
//     * @Decription: 将数据写入单元格
//     * @Modify:
//     */
//    private static void writeCell(Workbook workbook, Object obj, Cell cell) {
//        if (obj == null) {
//            cell.setCellValue("");
//        } else if (obj instanceof String) {
//            cell.setCellValue((String) obj);
//        } else if (obj instanceof Character) {
//            cell.setCellValue((Character) obj);
//        } else if (obj instanceof Long) {
//            cell.setCellValue((Long) obj);
//        } else if (obj instanceof Integer) {
//            cell.setCellValue((Integer) obj);
//        } else if (obj instanceof Short) {
//            cell.setCellValue((Short) obj);
//        } else if (obj instanceof Byte) {
//            cell.setCellValue((Byte) obj);
//        } else if (obj instanceof Float) {
//            cell.setCellValue((Float) obj);
//        } else if (obj instanceof Double) {
//            cell.setCellValue((Double) obj);
//        } else if (obj instanceof Boolean) {
//            cell.setCellValue((Boolean) obj);
//        } else if (obj instanceof Date) {
//            CellStyle cellStyle = workbook.createCellStyle();
//            CreationHelper createHelper = workbook.getCreationHelper();
//            cellStyle.setDataFormat(
//                    createHelper.createDataFormat().getFormat("yyyy/m/d h:mm:ss"));
//            cell.setCellValue((Date) obj);
//            cell.setCellStyle(cellStyle);
//        } else if (obj instanceof LocalDate) {
//            cell.setCellValue(LocalDateUtil.getDateAsString((LocalDate) obj));
//        } else if (obj instanceof LocalDateTime) {
//            cell.setCellValue(LocalDateUtil.getDateTimeAsString((LocalDateTime) obj));
//        }
//    }
//
//
//    /**
//     * @param: objList
//     * @param: clazz
//     * @param: attr
//     * @Return: java.util.List<java.util.List<java.lang.Object>>
//     * @Decription: 获取对象对应的字段的值
//     * @Modify:
//     */
//    private static <T> List<List<Object>> getValueList(List<T> objList, Class<T> clazz, List<String> attr) {
//        Set<Method> methods = ReflectionUtils.getAllMethods(clazz, Predicates.and(ReflectionUtils.withModifier(Modifier.PUBLIC),
//                ReflectionUtils.withPrefix("get")));
//        Map<String, Object> annotationMap = getAnnotaions(clazz);
//
//        Map<String, Method> methodMap = new HashMap<>();
//        for (Method method : methods) {
//            String attrName = ReflectionHelper.getAttrNameFromMethod(method.getName());
//            if (attr.contains(attrName)) {
//                methodMap.put(attrName, method);
//            }
//        }
//
//        if (methodMap.keySet().size() != attr.size()) {
//            throw new BusinessException(ResultCodeConstant.ERROR_SERVICE_CODE, "excel格式错误,列表和数据不一致,处理失败");
//        }
//
//        List<List<Object>> res = new ArrayList<>();
//        for (T obj : objList) {
//            List<Object> list = new ArrayList<>();
//            for (String name : attr) {
//                Method method = methodMap.get(name);
//                list.add(wrapperValue(method, name, annotationMap.get(name), obj));
//            }
//            res.add(list);
//        }
//        return res;
//    }
//
//    private static Object wrapperValue(Method method, String name, Object annotation, Object obj) {
//        String hasConvert = "";
//        Object value;
//        try {
//            value = method.invoke(obj);
//        } catch (Exception e) {
//            throw new BusinessException(ResultCodeConstant.ERROR_SERVICE_CODE, "excel格式错误,不能获取对应列的数据|" + name);
//        }
//
//        if (value != null) {
//            if (annotation instanceof ExcelPercent) {
//                ExcelPercent excelPercent = (ExcelPercent) annotation;
//                hasConvert = excelPercent.pre() + MoneyUtil.convertCentToString(getLongValue(value, name), 2) + "%";
//            } else if (annotation instanceof ExcelNum) {
//                ExcelNum excelNum = (ExcelNum) annotation;
//                hasConvert = excelNum.pre() + MoneyUtil.convertCentToString(getLongValue(value, name), 2) + excelNum.unit();
//            } else if (annotation instanceof ExcelUnit) {
//                ExcelUnit excelUnit = (ExcelUnit) annotation;
//                hasConvert = excelUnit.pre() + value + excelUnit.value();
//            }
//        }
//
//        if (hasConvert.equals("")) {
//            return value;
//        } else {
//            return hasConvert;
//        }
//    }
//
//    private static Long getLongValue(Object value, String name) {
//        Long conver2Long = 0L;
//        if (value instanceof Integer) {
//            conver2Long = ((Integer) value).longValue();
//        } else if (value instanceof Long) {
//            conver2Long = (Long) value;
//        } else {
//            throw new BusinessException(ResultCodeConstant.ERROR_SERVICE_CODE, "excel格式错误,当前类型无法转换" + name);
//        }
//        return conver2Long;
//    }
//
//    private static Map<String, Object> getAnnotaions(Class c) {
//        Map<String, Object> annotationMap = new HashMap<>();
//        Field[] fields = c.getDeclaredFields();
//        for (Field field : fields) {
//            if (field.getAnnotation(ExcelPercent.class) != null) {
//                annotationMap.put(field.getName(), field.getAnnotation(ExcelPercent.class));
//            } else if (field.getAnnotation(ExcelNum.class) != null) {
//                annotationMap.put(field.getName(), field.getAnnotation(ExcelNum.class));
//            } else if (field.getAnnotation(ExcelUnit.class) != null) {
//                annotationMap.put(field.getName(), field.getAnnotation(ExcelUnit.class));
//            }
//        }
//        return annotationMap;
//    }
//
//    private static void setAlign(CellStyle cellStyle, HorizontalAlignment halign, VerticalAlignment valign) {
//        cellStyle.setAlignment(halign);
//        cellStyle.setVerticalAlignment(valign);
//    }
//
//    private static void setBorder(CellStyle cellStyle, BorderStyle borderSize, IndexedColors colorIndex) {
//        cellStyle.setBorderBottom(borderSize);
//        cellStyle.setBottomBorderColor(colorIndex.index);
//        cellStyle.setBorderLeft(borderSize);
//        cellStyle.setLeftBorderColor(colorIndex.index);
//        cellStyle.setBorderRight(borderSize);
//        cellStyle.setRightBorderColor(colorIndex.index);
//        cellStyle.setBorderTop(borderSize);
//        cellStyle.setTopBorderColor(colorIndex.index);
//    }
//
//    private static void setColor(CellStyle cellStyle, short color, FillPatternType fillPattern) {
//        cellStyle.setFillForegroundColor(color);
//        cellStyle.setFillPattern(fillPattern);
//    }
//
//    public static void main(String[] args) throws Exception {
//        FileOutputStream fos=new FileOutputStream("D:\\test.xls");
//
//        String[] head0 = new String[]{"周期", "时间范围", "付款", "付款", "站外推广", "站外推广", "销售", "销售", "退款", "退款", "宝贝成本", "净销售", "净销售", "统计汇总", "统计汇总"};
//        String[] head1 = new String[]{" ", " ", "销量", "金额", "销量", "金额", "销量", "金额", "退款金额", "退回宝贝成本", "", "销量", "金额", "宝贝利润", "利润率"};
//        //对应excel中的行和列，（"开始行,结束行,开始列,结束列"）
//        String[] headnum0 = new String[]{"0,1,0,0", "0,1,1,1,", "0,0,2,3", "0,0,4,5", "0,0,6,7", "0,0,8,9", "0,1,10,10", "0,0,11,12", "0,0,13,14"};
//        List<String> attrList = Lists.newArrayList("reportDate", "dateRange", "saleNum", "payFee", "specialSaleNum", "specialSaleFee", "totalSaleNum", "saleFee", "refundFee",
//                "refundCost", "costFee", "retaSaleNum", "retaProfitFee", "profitFee", "profitPercent");
//
//        //组装头部Map
//        Map<Integer, Map<String, String[]>> headMap = Maps.newHashMap();
//        Map<String, String[]> head0InfoMap = Maps.newHashMap();
//        head0InfoMap.put(ExcelUtil.HEADNAME, head0);
//        head0InfoMap.put(ExcelUtil.HEADNUM, headnum0);
//
//        Map<String, String[]> head1InfoMap = Maps.newHashMap();
//        head1InfoMap.put(ExcelUtil.HEADNAME, head1);
//
//        headMap.put(0, head0InfoMap);
//        headMap.put(1, head1InfoMap);
//
//        //数据列表
//        List<ItemProfitExcelVo> itemProfitExcelVoList = Lists.newArrayList();
//        int i =10;
//        while (i<20){
//            i++;
//            ItemProfitExcelVo itemProfitExcelVo = new ItemProfitExcelVo();
//            itemProfitExcelVo.setReportDate("2019-06-"+i);
//            itemProfitExcelVo.setDateRange("2019-06-"+i);
//            itemProfitExcelVo.setPayFee(i+"元");
//            itemProfitExcelVo.setSaleNum(i+"个");
//            itemProfitExcelVoList.add(itemProfitExcelVo);
//        }
//
//        Workbook workbook = ExcelUtil.exportMergeXls(sheetName, itemProfitExcelVoList, attrList, headMap, ItemProfitExcelVo.class);
//        workbook.write(fos);
//        fos.close();
//    }
}
