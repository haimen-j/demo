package com.zuson.demo.excelUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Date;

public class ExcelDemo {

  public static void main(String[] args) {
      ClassPathResource resource = new ClassPathResource("template"+ File.separator +"信访详情统计模板.xlsx");
      ExportTemplateExcel template = null;
      try {
          //获取模板中的文件
          template = new ExportTemplateExcel(resource.getFile());
      } catch (IOException e) {
          e.printStackTrace();
      }
      Sheet sheet = template.getSheet();
      int lastRowNum = sheet.getLastRowNum()+1;//获取最大行数
      for (int i = 0; i < lastRowNum; i++) {
          XSSFRow row = (XSSFRow) sheet.getRow(i);
          if (row==null){
              continue;
          }
          for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
              XSSFCell cell = row.getCell(j) != null ? row.getCell(j) : row.createCell(j);//获取表格，如果表格为空创建一个表格
              int cellType = cell.getCellType();
              String cellValue = "";
              if(cellType == Cell.CELL_TYPE_STRING) { // 修改后的单元格都是 CELL_TYPE_STRING
                  cellValue = cell.getStringCellValue();
              }
              if (cellValue.startsWith("#month")){
                  template.setCellValue(cell,"八月");
              }
              if (cellValue.startsWith("#")){
                  String[] split = StringUtils.split(cellValue,".");
                  System.out.println(cellValue);
                  if (split[0].equals("#caseType")){
                      if (split[1].equals("air")){
                          template.setCellValue(cell,10);
                      }
                      if (split[1].equals("water")){
                          template.setCellValue(cell,5);
                      }
                      if (split[1].equals("waster")){
                          template.setCellValue(cell,2);
                      }
                      if (split[1].equals("noise")){
                          template.setCellValue(cell,9);
                      }
                      if (split[1].equals("violation")){
                          template.setCellValue(cell,7);
                      }
                      if (split[1].equals("other")){
                          template.setCellValue(cell,6);
                      }

                  }
                  if (split[0].equals("#area")){
                      if (split[1].equals("桃城区")){
                          template.setCellValue(cell,11);
                      }
                      if (split[1].equals("冀州区")){
                          template.setCellValue(cell,5);
                      }
                      if (split[1].equals("枣强县")){
                          template.setCellValue(cell,2);
                      }
                      if (split[1].equals("武邑县")){
                          template.setCellValue(cell,9);
                      }
                      if (split[1].equals("武强县")){
                          template.setCellValue(cell,7);
                      }
                      if (split[1].equals("饶阳县")){
                          template.setCellValue(cell,6);
                      } if (split[1].equals("安平县")){
                          template.setCellValue(cell,6);
                      } if (split[1].equals("故城县")){
                          template.setCellValue(cell,6);
                      } if (split[1].equals("景县")){
                          template.setCellValue(cell,6);
                      } if (split[1].equals("阜城县")){
                          template.setCellValue(cell,6);
                      }if (split[1].equals("高新区")){
                          template.setCellValue(cell,6);
                      }if (split[1].equals("滨湖新区")){
                          template.setCellValue(cell,6);
                      }if (split[1].equals("深州市")){
                          template.setCellValue(cell,6);
                      }
                  }
              }

          }

      }

      Font font = template.getWb().createFont();
      font.setFontHeightInPoints((short) 12);
      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      font.setFontName("黑体");
      CellStyle cellStyle = template.getWb().createCellStyle();//创建表格样式
      cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
      cellStyle.setFont(font);
      cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
      cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
      cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
      cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
      XSSFRow row = (XSSFRow) sheet.createRow(30);
      String [] title = {"日期","","案件总数","水污染","大气污染","噪声污染","固废污染","违规项目","其他"};
      for(int i = 0; i <8 ; i++) {
          XSSFCell cell = row.createCell(i);
          cell.setCellValue(title[i]);
          cell.setCellStyle(cellStyle);
          cell.setCellType(HSSFCell.CELL_TYPE_STRING);
      }
      CellRangeAddress rand = new CellRangeAddress(30,30,0,1);
      sheet.addMergedRegion(rand);
      String time = "";
      Date date = new Date();
      time = date.getTime()+"";
      File file = new File("D:\\template\\excel\\"+time+"\\模板.xlsx");
      if (!file.getParentFile().exists()){
          file.getParentFile().mkdirs();
      }
      FileOutputStream os = null;
      try {
          os = new FileOutputStream(file);
          template.write(os);
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }finally{
          try {
              os.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
}
