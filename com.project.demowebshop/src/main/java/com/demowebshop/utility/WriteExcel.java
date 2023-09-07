package com.demowebshop.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcel {
	
	HSSFWorkbook wb;
	HSSFSheet sheet;
	
	public void ExcelWriter(String path, String sheetName, int rowNo, int cellNo, String result) throws IOException {
		
		
		FileInputStream readFile = new FileInputStream(path);
		wb = new HSSFWorkbook(readFile);
		sheet = wb.getSheet(sheetName);
		sheet.getRow(rowNo).createCell(cellNo).setCellValue(result);
		FileOutputStream writeFile = new FileOutputStream(path);
		wb.write(writeFile);
		writeFile.flush();
		wb.close();		
	
				
		
		
	}

	public static void main(String[] args) throws IOException {


		WriteExcel er = new WriteExcel();
		er.ExcelWriter(".\\src\\main\\resources\\TestData.xls", "login_credentials", 0, 2, "Pass");

	}

}
