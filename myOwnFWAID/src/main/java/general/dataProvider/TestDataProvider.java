package general.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import myOwnFWGID.myOwnFWAID.Dao;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataProvider {

	Dao dao = new Dao();
	private String testCase;
	private String requiredCollumnValue;
	private String fromTable;
	public TestDataProvider(Object object) {
		this.testCase=object.getClass().toString();
	}



	public String getData(String requiredCollumnValue, String fromTable) {
		this.requiredCollumnValue=requiredCollumnValue;
		this.fromTable=fromTable;
		dao.executeQuery(this.requiredCollumnValue, this.fromTable, this.testCase);
		return null;
	}

}


//public String getData(String sheet, String column) {
//
//	actualDataSheetName=sheetName.split(" ");
//	sheetName = actualDataSheetName[1].replace(".", ",");
//	actualDataSheetName = sheetName.split(",");
//	sheetName=actualDataSheetName[1];
//	sheetName+=".xls";
//	
//
//	excelFilePath = "D:/Ashok_Workspace/myOwnFWAID/src/test/resources/"+sheetName;
//	excelFile = new File(excelFilePath);
//	try {
//		inputStream = new FileInputStream(excelFile);
//		workbook = new HSSFWorkbook(inputStream);
//
//		Sheet workSheet = workbook.getSheet(sheet);
//		
//		Iterator<Row> iterator = workSheet.iterator();
//		while (iterator.hasNext()) {
//			Row nextRow = iterator.next();
//			Iterator<Cell> cellIterator = nextRow.cellIterator();
//			while (cellIterator.hasNext()) {
//				 cell = cellIterator.next();
//				switch (cell.getCellType()) {
//				case Cell.CELL_TYPE_STRING:
//					System.out.print(cellData = cell.getStringCellValue());
//					break;
//				case Cell.CELL_TYPE_BOOLEAN:
//					System.out.print(cellData=cell.getBooleanCellValue());
//					break;
//				case Cell.CELL_TYPE_NUMERIC:
//					System.out.print(cellData=cell.getNumericCellValue());
//					break;
//				case Cell.CELL_TYPE_FORMULA:
//					System.out.print(cellData=cell.getNumericCellValue());
//					break;
//				}
//				System.out.print(" - ");
//			}
//
//		}
//		workbook.close();
//		inputStream.close();
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//	cellData=cellData.toString();
//	return (String) cellData;
//}
