package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class CompareExcelWithDB {
	Connection conn = null;
	Statement stmt = null;
	ResultSet resultSet = null;
	String dbName = "testing_rakesh";
	String port = "3306";
	String userName = "root";
	String password = "";
	String tableName = "employee";

	@Test
	public void testCompareExcelWithDB() throws ClassNotFoundException, SQLException, EncryptedDocumentException,
			InvalidFormatException, IOException {
		ExcelOperations ex= new ExcelOperations();
		
		

		List<String[]> excelList = ex.getExcelData("employee");

		List<String[]> dataBaseList = connectDBGetData(dbName, tableName, port, userName, password);
		ex.writeDBData("dbdata", dataBaseList);

		if (excelList.size() == dataBaseList.size()) {
			System.out.println("rows matched");

		} else {
			System.out
					.println("excel rows are " + excelList.size() + "  database table rows are" + dataBaseList.size());

		}
		for (int i = 0; i < excelList.size(); i++) {
			String status = null;
			for (int j = 0; j < excelList.get(i).length; j++) {
				if (excelList.get(i)[j].equals(dataBaseList.get(i)[j])) {
					status = "true";

				} else {
					status = "false";
					ex.writeResult("result", i, "Error : Excel record value is " + excelList.get(i)[j]
							+ "  but data base record value is  " + dataBaseList.get(i)[j]);

					break;

				}

			}
			System.out.println(status);
			if (status.equals("true")) {
				ex.writeResult("result", i, status);
			}

		}
		ex.closeExcelStream();
		closeConnections();

	}

	private List<String[]> connectDBGetData(String dbName, String tableName, String port, String userName,
			String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + dbName, userName, password);

		stmt = conn.createStatement();
		resultSet = stmt.executeQuery("select * from " + tableName);
		int columnCount = resultSet.getMetaData().getColumnCount();

		String[] record;

		List<String[]> data = new ArrayList<>();
		while (resultSet.next()) {
			record = new String[columnCount];
			for (int j = 0; j < record.length; j++) {
				record[j] = resultSet.getString(j + 1).trim();
			}

			data.add(record);
		}
		return data;
	}

	private void closeConnections() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
