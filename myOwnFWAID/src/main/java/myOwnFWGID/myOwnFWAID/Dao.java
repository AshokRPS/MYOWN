package myOwnFWGID.myOwnFWAID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	
	private Connection connection = null;
	private Statement statement = null;
	private	ResultSet resultSet = null;
	private PreparedStatement preparedStatement =null;

	
	public Connection  connectDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/gs","root","root");  

		}
		catch(Exception e){
			e.printStackTrace();

		}
		return connection;	
	}
	
	public Statement createStatement() {
		try {
			statement=connectDB().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}  

		return statement;
		
	}
	


	public ResultSet executeQuery(String requiredCollumnValue, String fromTable,
			String testCase) {
		

		String[] actualDataSheetName;
		actualDataSheetName=testCase.split(" ");
		testCase = actualDataSheetName[1].replace(".", ",");
		actualDataSheetName = testCase.split(",");
		testCase=actualDataSheetName[1];
		
		System.out.println(requiredCollumnValue);
		System.out.println(fromTable);
		System.out.println(testCase);
		
		String query = "select " +requiredCollumnValue+" from "+fromTable+" where TCID='"+testCase+"'";
		
		try {
		
			resultSet = createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		  try {
			while (resultSet.next()) {
				System.out.println(resultSet.getString(requiredCollumnValue));  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return resultSet;
		// TODO Auto-generated method stub
		
	}
	
	
	

}
