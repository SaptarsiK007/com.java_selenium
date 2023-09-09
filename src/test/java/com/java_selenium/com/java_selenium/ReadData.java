package com.java_selenium.com.java_selenium;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadData {
	
	
	FileInputStream fs;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static int rowCount;
	
	public static void main(String[] args) throws IOException
	{
	String path = System.getProperty("user.dir");
	FileInputStream fs = new FileInputStream(path+"\\src\\main\\TestData\\TestData.xlsx");
	//Creating a workbook
	wb = new XSSFWorkbook(fs);
	sheet = wb.getSheet("sheet1");
	//Row row = sheet.getRow(0);
	//Cell cell = row.getCell(0);
	//System.out.println(sheet.getRow(1).getCell(1));
	String test = "TC001";
	rowCount = sheet.getLastRowNum();
	//System.out.println(rowCount);
	
	ReadData ob = new ReadData();
	String Testdata = ob.GetData("TC003","Keyword2");
	System.out.println(Testdata);
	}
	
	public String GetData(String test1,String test2 )
	{
		int x = returnrownum(test1);
		int y = returncolnum(test2);
		String data = sheet.getRow(x).getCell(y).toString();
		
		return data;
	}
	
	
	public int returnrownum(String test)
	{
		int c=0;
		int rowIndex;
	// Iterate through the rows of the sheet
	for (rowIndex = 0; rowIndex <= rowCount; rowIndex++)
		{
        Row row = sheet.getRow(rowIndex);
        if (row != null)
        	{
            int columnCount = row.getLastCellNum(); // Get the number of columns in the current row
            // Iterate through the columns in the current row
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
            	{
                Cell cell = row.getCell(columnIndex);
                // Check the cell's data type and compare its value to the targetValue
                if (cell != null &&
                        cell.getStringCellValue().equals(test)) 
                	{
                    // Print the row and column number where the value is found
                    	//System.out.println("Found '" + test + "' at Row " + rowIndex + ", Column " + columnIndex);
                    c = rowIndex;	
                	break;
                	}
                
            	}
            }
        
         // Move to the next row
		}
	return c;
	}
	
	public int returncolnum(String test)
	{
		int c=0;
		int rowIndex;
	// Iterate through the rows of the sheet
	for (rowIndex = 0; rowIndex <= rowCount; rowIndex++)
		{
        Row row = sheet.getRow(rowIndex);
        if (row != null)
        	{
            int columnCount = row.getLastCellNum(); // Get the number of columns in the current row
            // Iterate through the columns in the current row
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
            	{
                Cell cell = row.getCell(columnIndex);
                // Check the cell's data type and compare its value to the targetValue
                if (cell != null &&
                        cell.getStringCellValue().equals(test)) 
                	{
                    // Print the row and column number where the value is found
                    	//System.out.println("Found '" + test + "' at Row " + rowIndex + ", Column " + columnIndex);
                    c = columnIndex;	
                	break;
                	}
            	}
            }
         // Move to the next row
		}
	return c;
	}
}
	
	
	
