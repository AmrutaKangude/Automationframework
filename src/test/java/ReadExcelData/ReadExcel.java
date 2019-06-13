package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args)throws Exception {
		
		File src=new File("E:\\amruta\\java _practice\\automationframework\\src\\test\\java\\testData\\TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet1= wb.getSheetAt(0);
		/*String data=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data from Excel "+data);
		
		String data1=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Data from Excel "+data1);
		
		String data2=sheet1.getRow(0).getCell(2).getStringCellValue();
		System.out.println("Data from Excel "+data2);
		*/
		
		int rowcount=sheet1.getLastRowNum();
		System.out.println("Totals no.of rows "+rowcount++);
		for(int i=0;i<rowcount;i++)
		{	
		String data1=sheet1.getRow(i).getCell(0).getStringCellValue();
		System.out.println("Data from row "+i+" is "+data1);
		}
		
		
		wb.close();
	}

	

}
