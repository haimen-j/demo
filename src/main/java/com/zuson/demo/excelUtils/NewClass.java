package com.zuson.demo.excelUtils;

import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServlet;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServlet;

public class NewClass extends HttpServlet {
  /** Excel 文件要存放的位置，假定在D盘下 */
  public static String outputFile = "D:\\template\\excel\\test.xls";

  private void cteateCell(HSSFWorkbook wb, HSSFRow row, short col, String val) {
    HSSFCell cell = row.createCell(col);
    // cell.setEncoding(HSSFCell.ENCODING_UTF_16);
    cell.setCellValue(val);
    HSSFCellStyle cellstyle = wb.createCellStyle();
    cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
    cell.setCellStyle(cellstyle);
  }

  public static void main(String argv[]) {
    try {
      // 创建新的Excel 工作簿
      HSSFWorkbook workbook = new HSSFWorkbook();

      // 设置字体
      HSSFFont font = workbook.createFont();
      // font.setColor(HSSFFont.COLOR_RED);
      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      font.setFontHeightInPoints((short) 14);

      // HSSFFont font2 = workbook.createFont();
      // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      // font.setFontHeightInPoints((short)14);

      // 设置样式
      HSSFCellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

      // HSSFCellStyle cellStyle2= workbook.createCellStyle();
      // cellStyle.setFont(font2);
      // cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

      // 在Excel工作簿中建一工作表，其名为缺省值
      // 如要新建一名为"月报表"的工作表，其语句为：
      HSSFSheet sheet = workbook.createSheet("月报表");
      CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 11);
      sheet.addMergedRegion(cellRangeAddress);

      // 第一行
      // 在索引0的位置创建行（最顶端的行）
      HSSFRow row = sheet.createRow(0);
      // 在索引0的位置创建单元格（左上端）
      HSSFCell cell = row.createCell(0);
      // 定义单元格为字符串类型
      cell.setCellType(HSSFCell.CELL_TYPE_STRING);
      cell.setCellStyle(cellStyle);
      // 在单元格中输入一些内容
      cell.setCellValue(new HSSFRichTextString("北京亿卡联科技发展有限公司小区门禁维修月报表"));

      // 第二行
      cellRangeAddress = new CellRangeAddress(1, 1, 3, 6);
      sheet.addMergedRegion(cellRangeAddress);
      row = sheet.createRow(1);
      HSSFCell datecell = row.createCell(3);
      datecell.setCellType(HSSFCell.CELL_TYPE_STRING);
      datecell.setCellStyle(cellStyle);
      datecell.setCellValue("时间间隔xxxxx");

      cellRangeAddress = new CellRangeAddress(1, 1, 9, 10);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(9).setCellValue("单位：元");

      // 第三行
      row = sheet.createRow(2);
      row.createCell(0).setCellValue("一、");
      row.createCell(1).setCellValue("基本资料");

      // 第4行
      row = sheet.createRow(3);
      row.createCell(1).setCellValue("小区名称：");
      cellRangeAddress = new CellRangeAddress(3, 3, 2, 11);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(2).setCellValue("xxxxx");

      // 第5行
      row = sheet.createRow(4);
      row.createCell(1).setCellValue("座落地点：");
      cellRangeAddress = new CellRangeAddress(4, 4, 2, 11);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(2).setCellValue("xxxxx");

      // 第6行
      row = sheet.createRow(5);
      row.createCell(1).setCellValue("建成年月：");
      cellRangeAddress = new CellRangeAddress(5, 5, 2, 4);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(2).setCellValue("年月日：xxxxx");
      row.createCell(5).setCellValue("联系人");
      cellRangeAddress = new CellRangeAddress(5, 5, 6, 8);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(6).setCellValue("XXX");
      row.createCell(9).setCellValue("电话");
      cellRangeAddress = new CellRangeAddress(5, 5, 10, 11);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(10).setCellValue("XXX");

      // 第7行
      row = sheet.createRow(6);
      row.createCell(1).setCellValue("住户：");
      row.createCell(2).setCellValue("(XX)");
      row.createCell(3).setCellValue("(户)");
      cellRangeAddress = new CellRangeAddress(6, 6, 4, 5);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(4).setCellValue("共计（      ）");
      row.createCell(6).setCellValue("幢");
      cellRangeAddress = new CellRangeAddress(6, 6, 7, 8);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(7).setCellValue("发卡张数");
      cellRangeAddress = new CellRangeAddress(6, 6, 9, 10);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(9).setCellValue("xxxx");

      // 第9行
      row = sheet.createRow(8);
      row.createCell(0).setCellValue("二、");
      cellRangeAddress = new CellRangeAddress(8, 8, 1, 2);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(1).setCellValue("维修用材料台账");
      row.createCell(6).setCellValue("三、");
      cellRangeAddress = new CellRangeAddress(8, 8, 7, 9);
      sheet.addMergedRegion(cellRangeAddress);
      row.createCell(7).setCellValue("维修工时记录");
      // 第10行
      row = sheet.createRow(9);
      row.createCell(0).setCellValue("日期");
      row.createCell(1).setCellValue("维修事项");
      row.createCell(2).setCellValue("材料清单");
      row.createCell(3).setCellValue("数量");
      row.createCell(4).setCellValue("单价");
      row.createCell(5).setCellValue("材料金额");

      row.createCell(7).setCellValue("日期");
      row.createCell(8).setCellValue("技工");
      row.createCell(9).setCellValue("工时数");
      row.createCell(10).setCellValue("单价");
      row.createCell(11).setCellValue("工时金额");

      // 填充数据
      for (int i = 0; i < 10; i++) {
        row = sheet.createRow(9 + i + 1);
        row.createCell(0).setCellValue("日期");
        row.createCell(1).setCellValue("维修事项");
        row.createCell(2).setCellValue("材料清单");
        row.createCell(3).setCellValue("数量");
        row.createCell(4).setCellValue("单价");
        row.createCell(5).setCellValue("材料金额");

        row.createCell(7).setCellValue("日期");
        row.createCell(8).setCellValue("技工");
        row.createCell(9).setCellValue("工时数");
        row.createCell(10).setCellValue("单价");
        row.createCell(11).setCellValue("工时金额");
      }

      // 第n+10行
      row = sheet.createRow(9 + 10 + 1);
      // cellRangeAddress=new CellRangeAddress(19,19,0,4);
      // sheet.addMergedRegion(cellRangeAddress);
      row.createCell(0).setCellValue("累计:");
      row.createCell(1).setCellValue("xxx");
      row.createCell(7).setCellValue("累计:");
      row.createCell(8).setCellValue("xxx");

      // 新建一输出文件流
      FileOutputStream fOut = new FileOutputStream(outputFile);
      // 把相应的Excel 工作簿存盘
      workbook.write(fOut);
      fOut.flush();
      // 操作结束，关闭文件
      fOut.close();
      System.out.println("文件生成...");
    } catch (Exception e) {
      System.out.println("已运行 xlCreate() : " + e);
    }
  }
}
