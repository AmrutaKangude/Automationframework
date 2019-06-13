package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Base {
	String getCurrentDirectoryPathAndConcat(String path) {
		String currentPath=System.getProperty("user.dir");
		currentPath=currentPath + path;
		return currentPath;
	}
	void readFile(String filename) {
		String ext=".xslx";
		String path="\\src\\test\\java\\data\\";
		
		path=this.getCurrentDirectoryPathAndConcat(path+filename+ext);
		System.out.println(path);
		File file=new File(path);
		
		try {
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("sample");
			XSSFRow row=sheet.getRow(0);
			for(int i=0;i<100;i++) {
			
			XSSFCell cell=row.getCell(i);
			System.out.println(cell.getStringCellValue());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void writeFile(String filename) {
		String ext=".xslx";
		String path="\\src\\test\\java\\data\\";
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("sample");
		
		for(int i=0;i<100;i++) {
		XSSFRow row=sheet.createRow(i);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("Inportia IT Solutions");
		}
		path=this.getCurrentDirectoryPathAndConcat(path+filename+ext);
		System.out.println(path);
		File file=new File(path);
		try {
			FileOutputStream fos=new FileOutputStream(file);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	}

