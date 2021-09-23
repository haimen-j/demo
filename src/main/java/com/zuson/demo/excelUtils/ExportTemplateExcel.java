package com.zuson.demo.excelUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 导出模板excel
 * @author 李梦杰
 * @date 2020-08-29
 */
public class ExportTemplateExcel {
	private static Logger log = LoggerFactory.getLogger(ExportTemplateExcel.class);

    /**
     * 工作薄对象
     */
    private Workbook wb;

    /**
     * 工作表对象
     */
    private Sheet sheet;

    /**
     * 构造函数
     * @param fileName
     * @throws IOException
     */
    public ExportTemplateExcel(String fileName) throws IOException {
        this(new File(fileName));
    }

    /**
     * 构造函数
     * @param file
     * @throws IOException
     */
    public ExportTemplateExcel(File file) throws IOException {
        this(file, 0);
    }

    /**
     * 构造函数
     * @param fileName 文件名（需能找到文件）
     * @param sheetIndex
     * @throws IOException
     */
    public ExportTemplateExcel(String fileName, int sheetIndex) throws IOException {
        this(new File(fileName), sheetIndex);
    }

   
    /**
     * 构造函数
     * @param file 模板文件File
     * @param sheetIndex sheet页位置
     * @throws IOException
     */
    public ExportTemplateExcel(File file, int sheetIndex) throws IOException {
        this(file.getName(), new FileInputStream(file), sheetIndex);
    }

    /**
     * 构造函数
     * @param multipartFile request消息中上传的文件
     * @param sheetIndex 工作表编号
     * @throws IOException
     */
    public ExportTemplateExcel(MultipartFile multipartFile, int sheetIndex)throws IOException {
        this(multipartFile.getOriginalFilename(), multipartFile.getInputStream(), sheetIndex);
    }
    
    /**
     * 构造函数
     *
     * @param sheetIndex 工作表编号
     * @throws InvalidFormatException
     * @throws IOException
     */
    private ExportTemplateExcel(String fileName, InputStream is, int sheetIndex) throws IOException{
        if (StringUtils.isBlank(fileName)) {
            throw new RuntimeException("导入文档为空!");
        } else if (fileName.toLowerCase().endsWith("xls")) {
            this.wb = new HSSFWorkbook(is);
        } else if (fileName.toLowerCase().endsWith("xlsx")) {
            this.wb = new XSSFWorkbook(is);
        } else {
            throw new RuntimeException("文档格式不正确!");
        }
        if (this.wb.getNumberOfSheets() < sheetIndex) {
            throw new RuntimeException("文档中没有工作表!");
        }
        this.sheet = this.wb.getSheetAt(sheetIndex);
        log.debug("Initialize success.");
    }
    
    public void setCellValue(XSSFCell cell, Object val) {
		if(val == null || val == "") {
			return;
		}
    	
		if (val instanceof String) {
			// cell 类型
	    	int cellType = cell.getCellType();
	    	if(cellType == Cell.CELL_TYPE_NUMERIC) {
	    		cell.setCellValue(Double.valueOf(val.toString()));
	    	}else if(cellType == Cell.CELL_TYPE_STRING) {
	    		cell.setCellValue(val.toString());
	    	}else {
	    		// TODO 暂时不进行操作
	    	}
		} else if (val instanceof Integer) {
			cell.setCellValue((Integer) val);
		} else if (val instanceof Long) {
			cell.setCellValue((Long) val);
		} else if (val instanceof Double) {
			cell.setCellValue((Double) val);
		} else if (val instanceof Float) {
			cell.setCellValue((Float) val);
		} else if (val instanceof Date) {
			cell.setCellValue((Date) val);
		} else {
			
		}
	}
    
    /**
     * 获取属性名中索引列表
     * @param propertyName 索引定义规则“[d]”
     * @return
     */
    public static List<Integer> getPropertyNameIndexs(String propertyName) {
	    return getPropertyNameIndexs(propertyName, "");
    }
    
    /**
     * 获取属性名中索引列表
     * @param propertyName 索引定义规则“[d]”
     * @return
     */
    public static int getPropertyNameIndex(String propertyName, String prefixName) {
    	List<Integer> indexs = getPropertyNameIndexs(propertyName, "");
    	if(indexs.size()>0) {
    		return indexs.get(0);
    	}
    	return -1;
    }
    
    /**
     * 获取属性名中索引列表
     * @param propertyName 索引定义规则“[d]”
     * @return
     */
    public static List<Integer> getPropertyNameIndexs(String propertyName, String prefixName) {
    	Pattern pattern = Pattern.compile(prefixName+"\\[\\d+\\]"); 
    	Matcher matcher = pattern.matcher(propertyName); 
    	List<Integer> indexs = new ArrayList<>();
    	while (matcher.find()) {
    		String result = matcher.group(0);
    		indexs.add(Integer.valueOf(result.replace(prefixName+"[", "").replace("]", "")));
    	} 
    	return indexs;
    }
    
    /**
	 * 输出数据流
	 * @param os 输出数据流
	 */
	public ExportTemplateExcel write(OutputStream os) throws IOException{
		wb.write(os);
		return this;
	}
	
	/**
	 * 输出到客户端
	 * @param fileName 输出文件名
	 */
	public ExportTemplateExcel write(HttpServletResponse response, String fileName) throws IOException{
		response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+Encodes.urlEncode(fileName));
		write(response.getOutputStream());
		return this;
	}
	
	/**
	 * 输出到文件
	 */
	public ExportTemplateExcel writeFile(String name) throws FileNotFoundException, IOException{
		FileOutputStream os = new FileOutputStream(name);
		this.write(os);
		return this;
	}
	
	public Workbook getWb() {
		return wb;
	}

	public void setWb(Workbook wb) {
		this.wb = wb;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}
}
