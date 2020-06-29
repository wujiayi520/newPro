package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class PoiMethod {
	private static XSSFWorkbook book;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	private static FileInputStream inputStream;
	private  static FileOutputStream outputStream;
	private  static String filePath ;

	//本文主要实现.xlsx的文件操作
	/*public static void main(String[] args) {
		
		//设定要操作的Excel的文件路径和Excel文件中的名名称
		//String string=System.getProperty("user.dir");
		
	}*/
	//设定文件及sheet页
	public static void setExcel(String excelPath ,String sheetName) {
		if(excelPath==null||excelPath=="") {
			System.out.println("请输入正确的文件路径");
			return;
		}
		filePath=excelPath;
		
		try {
			inputStream=new FileInputStream(new File(excelPath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			book=new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(sheetName==null||sheetName=="") return; 
		sheet=book.getSheet(sheetName);
		
		
	}
	//读取数据
	public static String getData(int rowNum,int cellNum) {
		cell=sheet.getRow(rowNum).getCell(cellNum);
		String data=cell.getStringCellValue();
		return data;
		
	}
	
	//写入数据
	public static void setData(int rowNum,int cellNum,String result) {
		//System.out.println(result);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		if (cell==null) {
			cell=row.createCell(cellNum);
			//cell.setCellValue(result);
			cell.setCellValue(result);
			
		} else {
			cell.setCellValue(result);
		}
		try {
			outputStream =new FileOutputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			outputStream.flush();
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}