package ReadExcelData;

public class ReadData {

	public static void main(String[] args) {
	
		ReadExcelConfig excel=new ReadExcelConfig("E:\\amruta\\java _practice\\automationframework\\src\\test\\java\\testData\\TestData.xlsx");
		System.out.println(excel.getData(1, 0, 1));
	}

}
