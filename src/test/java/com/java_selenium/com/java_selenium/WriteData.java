package com.java_selenium.com.java_selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class WriteData {
	
	FileInputStream fs;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		String path = System.getProperty("user.dir");
		FileInputStream fs = new FileInputStream(path+"\\src\\main\\TestData\\TestData.xlsx");
		//FileOutputStream fw = new FileOutputStream(); 
		//Creating a workbook
		wb = new XSSFWorkbook(fs);
		//sheet = wb.getSheet("sheet2");
		sheet = wb.getSheet("New Sheet");
		//Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		//System.out.println(sheet.getRow(1).getCell(1));	
		//String test = "TC001";
		//rowCount = sheet.getLastRowNum();
		//System.out.println(rowCount);
		int cellindex = 0;
		String singleValue = "Text1";
		int lastRowIndex = sheet.getLastRowNum();
		//System.out.println(lastRowIndex);
		  // Find the last cell in the specified column
        int lastCellIndex = 0;
        for (int i = 0; i <= lastRowIndex; i++) {
        	for(int j=0; j<= lastCellIndex;j++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(0); // Assuming you want to check column 0 (A)
                if (cell != null) {
                	System.out.println(cell.getStringCellValue());
                    lastCellIndex = cell.getColumnIndex();
                    System.out.println(lastCellIndex);
                    lastCellIndex++;
                	
                }
            }
        }}
        
        // Increment the last cell index to write to the next cell in the same column
        

        // Create a new row (or use an existing one) and write to the next cell
        Row row = sheet.getRow(lastRowIndex);
        if (row == null) {
            row = sheet.createRow(lastRowIndex);
        }
        Cell cell = row.createCell(lastCellIndex);
        cell.setCellValue(singleValue);


		 	
	        // Write the workbook to an Excel file
	        try (FileOutputStream outputStream = new FileOutputStream(path+"\\src\\main\\TestData\\TestData.xlsx")) {
	            wb.write(outputStream);
	            System.out.println("Data written to data.xlsx");
	            outputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    

	}

}
