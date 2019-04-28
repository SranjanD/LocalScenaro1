package Automation.Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class excelWork extends elementIdentification{
	public static XSSFWorkbook workBook;
	public static XSSFSheet workSheet;
	public static XSSFRow excelRows;
	public static XSSFCell excelColumn;
	Map<String, String> excel = new HashMap<String, String>();

	public static void loadExcel() throws Exception {
		File file = new File("src\\main\\Data\\TestCaseData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		workBook = new XSSFWorkbook(fis);
	}
    
	@DataProvider(name = "extractData")
	public Object[][] getExcelData() throws Exception {
		loadExcel();
		workSheet = workBook.getSheet("TestData");
		int totalColumn = workSheet.getRow(0).getLastCellNum();
		Map<String, String> excel = new HashMap<String, String>() ;
		Object[][] testData = new Object[workSheet.getLastRowNum()][1];
		
        for(int row =0; row<workSheet.getLastRowNum(); row++) {
		  for (int i = 0; i<totalColumn; i++) {
			//excelColumn =  workSheet.getCellComment(0, i);
			XSSFCell fieldValue0 = workSheet.getRow(0).getCell(i);
			DataFormatter dmt = new DataFormatter();
			String fieldValue1 =  dmt.formatCellValue(workSheet.getRow(1).getCell(i));
			excel.put(fieldValue0.toString(), fieldValue1);
		    }
		   testData[row][0] = excel;
        }

		return testData;
	}
}
