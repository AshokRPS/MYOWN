package myOwnFWGID.myOwnFWAID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Hello world!
 * 
 */
public class App {

	public static void main(String[] args) throws Throwable {
		// System.out.println("Hello World!");
		// new App().maxOfSumOfSubArray();
		// new App().checkList();
//		 new App().countAlphabets();
//		new App().getData("Sheet1", "c1");
		new App().dao();

	}
	
	 public void dao() throws Exception{
		
		 Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/gs","root","root");  
			statement=connection.createStatement();
			String query = "select " +"KEYWORD"+" from "+"googleSearchTestData"+" where TCID ="+"'Test1'";

			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String ee=resultSet.getString("KEYWORD");
				System.out.println(ee);  
			  }
			


	 }
	public void maxOfSumOfSubArray() {

		System.out.println("maxOfSumOfSubArray()");
		int[][] intArray = new int[5][5];
		int val = 0;
		int sum = 0;
		int max[] = new int[5];
		int maxval = 0;
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				intArray[a][b] = val++;
			}
		}
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				System.out.print(" " + intArray[a][b]);
				sum = sum + intArray[a][b];
			}
			System.out.print("          " + sum);
			System.out.println(" ");
			max[a] = sum;
			sum = 0;
		}
		System.out.println("sum of sub array's values ");
		for (int a = 0; a < 5; a++) {
			System.out.print(" " + max[a]);
		}
		System.out.println("");
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				if (max[a] > max[b]) {
					maxval = max[a];
					break;
				}
			}
		}
		System.out.println("the max of sub array   " + maxval);

	}

	public void checkList() {

		System.out.println("checkList()");
		LinkedList<Integer> listObj = new LinkedList<Integer>();

		for (int i = 1; i <= 5; i++) {
			listObj.add(i);
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(" " + listObj.get(i));
		}

		int n = 2;
		int listSize = listObj.size();
		System.out.println(" ");
		System.out.println(listSize);
		System.out.println(listSize - n);
		System.out.println(listObj.get(listSize - n));
	}

	public void countAlphabets() {
		System.out.println("countAlphabets()");
		String str = "abcgahjk";
		str += "\u0000";
		String[] str1 = str.split("");
		String first = str1[0];
		int count = 0;
		ArrayList<String> arrayList = new ArrayList<String>();
		System.out.println(str1.length);

		for (int i = 0; i < str1.length; i++) {
			System.out.print(str1[i]);
			if (first.equalsIgnoreCase(str1[i])) {
				count++;
			} else {
				arrayList.add(count + first);
				first = str1[i];
				count = 1;
			}

		}

		for (String string : arrayList) {
			System.out.print(" " + string);

		}

	}

	private FileInputStream inputStream;
	private String excelFilePath;
	
	private Workbook workbook;
	File excelFile;
	Object cellData;
	String sheetName;
	String actualDataSheetName[];

	public App() {
		sheetName=this.getClass().toString();
	}

	public String getData(String sheet, String column) {
		
		
		System.out.println(sheetName);
		actualDataSheetName=sheetName.split(" ");
		sheetName = actualDataSheetName[1].replace(".", ",");
		actualDataSheetName = sheetName.split(",");
		sheetName=actualDataSheetName[2];
		for (String string1 : actualDataSheetName) {
			System.out.println(string1);
			
		}
		System.out.println(sheetName);
		

		excelFilePath = "D:/Ashok_Workspace/myOwnFWAID/src/test/resources/"+sheetName;
		excelFile = new File(excelFilePath);
		try {
			inputStream = new FileInputStream(excelFile);
			workbook = new HSSFWorkbook(inputStream);

			Sheet workSheet = workbook.getSheet(sheet);
			Iterator<Row> iterator = workSheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(cellData = cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cellData=cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cellData=cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						System.out.print(cellData=cell.getNumericCellValue());
						break;
					}
					System.out.print(" - ");
				}

			}
			workbook.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		cellData=cellData.toString();
		return (String) cellData;
	}

	 Connection connection = null;
	 Statement statement = null;
		ResultSet resultSet = null;
		private PreparedStatement preparedStatement =null;


	
}
