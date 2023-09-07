package com.demowebshop.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	
	HSSFWorkbook wb;
	HSSFSheet sheet;
	
	public String ExcelReader(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		
		
		FileInputStream readFile = new FileInputStream(path);
		wb = new HSSFWorkbook(readFile);
		sheet = wb.getSheet(sheetName);
		
		String data = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();		
		
		wb.close();;
		
		return data;		
		
		
	}
	

	
	public int getLastRow(String path, String sheetName) throws IOException {
		
		FileInputStream file = new FileInputStream(path);
		wb = new HSSFWorkbook(file);
		sheet = wb.getSheet(sheetName);
		int lastRowNo = sheet.getLastRowNum();		
		return lastRowNo;		
		
	}
	
	
	
	public static void main(String args[]) throws IOException {
		
		ReadExcel er = new ReadExcel();		
		
		int lastRowNo = er.getLastRow(".\\src\\main\\resources\\TestData.xls", "login_credentials");
		
						
		for(int i=1; i<=lastRowNo; i++) {
					
						
			String username = er.ExcelReader(".\\src\\main\\resources\\TestData.xls", "login_credentials", i, 0);
			String password = er.ExcelReader(".\\src\\main\\resources\\TestData.xls", "login_credentials", i, 1);
								
			System.out.println(username+" "+password + " " +i);
		}
				
		
	}

}
