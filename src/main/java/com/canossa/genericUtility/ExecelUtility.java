package com.canossa.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExecelUtility {
	Workbook workbook;
	FileInputStream fisExcel;
	FileOutputStream fos;
	DataFormatter df;
	
	/**
	 * To read data from Excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	
	public String getDataFromExcel(String excelPath, String sheetName,int rowNumber, int cellNumber) {
		try {
			fisExcel=new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		df=new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}

	/**
	 * To write data to excel
	 * @param data
	 * @param rowNum
	 * @param cellNum
	 */
	public void setDataToExcel(String data, int rowNum, int cellNum) {
		workbook.getSheet("Sheet1").getRow(rowNum).getCell(cellNum).setCellValue(data);
		try {
			fos=new FileOutputStream("./src/test/resources/ExpectedDataSpecialization.xlsx");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * This method is used to fetch multiple data from excel and store in String[][]
	 * @param sheetName
	 * @return
	 */
	public String[][] getDataFromExcel(String sheetName){
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNumber = sheet.getLastRowNum();// return index ==> index
		short lastcellNumber = sheet.getRow(0).getLastCellNum();//return count/size ==> count
		String[][] arr=new String[lastRowNumber][lastcellNumber];
		for(int i=0; i<lastRowNumber;i++) {
			for(int j=0;j<lastcellNumber;j++) {
				arr[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				
			}
		}
		return arr;
	}
	
	public String getDataFromExcel(String sheetName, String expectedKey) {
		Sheet sheet = workbook.getSheet(sheetName);
		short lastcellNumber=sheet.getRow(0).getLastCellNum();
		String value="";
		for(int i=0;i<lastcellNumber;i++) {
			String actualKey=sheet.getRow(0).getCell(i).getStringCellValue();
			if(actualKey.equals(expectedKey)) {
				value=sheet.getRow(1).getCell(i).getStringCellValue();
				break;
			}
				
		}
		return value;
	}
	/**
	 * To close the excel
	 * @throws IOException
	 */
	public void closeExcel() throws IOException 
	{
		workbook.close();
		fisExcel.close();
		
		
	
	
	}

}
