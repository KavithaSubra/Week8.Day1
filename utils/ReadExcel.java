package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
public static String[][] readExcel(String fileName) throws IOException {
	//Set the path of the excel file
	XSSFWorkbook wb= new XSSFWorkbook("./data/"+ fileName +".xlsx");
	
	//Get into the sheet
	XSSFSheet ws = wb.getSheetAt(0);
	
	//wb.getSheetAt(0);
	
	//Get no. of rows excluding header
	int rowCount = ws.getLastRowNum();
	//System.out.println(rowCount);
	
	//Get rows including header
	
	int totalRowsCount = ws.getPhysicalNumberOfRows();
	//System.out.println(totalRowsCount);
	
	//Get no. of Cells from Header
	
	short cellCount = ws.getRow(0).getLastCellNum();
	//System.out.println(cellCount);
	
	String[][] data = new String[rowCount][cellCount];
	
	//Get into first row excluding the header
	for(int i=1; i<=rowCount;i++)
	{
		XSSFRow row = ws.getRow(i);
	
		for (int j=0;j<cellCount;j++)
	     {
	        //Get into first cell
	
	        XSSFCell cell = row.getCell(j);
	
	        //Retrieve the data
	
	        String cellValue = cell.getStringCellValue();
	
	        data[i-1][j]=cellValue;
	
          }
	}
	//Close the workbook
	wb.close();
	return data;
}
}
