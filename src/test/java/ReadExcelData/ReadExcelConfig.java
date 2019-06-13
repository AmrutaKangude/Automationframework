package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ReadExcelConfig(String excelPath) {
		
		try {
			File src=new File("E:\\amruta\\java _practice\\automationframework\\src\\test\\java\\testData\\TestData.xlsx");
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
					}  catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	public String getData(int sheetNumber,int row,int collumn) {
		sheet1=wb.getSheetAt(sheetNumber);

		String data=sheet1.getRow(row).getCell(collumn).getStringCellValue();
		return data;
	}
}
