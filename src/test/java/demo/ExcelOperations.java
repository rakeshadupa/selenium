package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	static String filePath = "./src/databaseSheet.xlsx";

	public static List<String[]> getExcelData(String sheetName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook w = WorkbookFactory.create(fis);
		Sheet s = w.getSheet(sheetName);
		int rowCount = s.getLastRowNum();
		int columnCount = s.getRow(0).getLastCellNum();
		List<String[]> data = new ArrayList<>();
		String[] rows = null;
		for (int i = 1; i <= rowCount; i++) {
			rows = new String[columnCount];
			for (int j = 0; j < columnCount; j++) {
				DataFormatter format = new DataFormatter();
				rows[j] = format.formatCellValue(s.getRow(i).getCell(j)).trim();

			}
			data.add(rows);

		}
		return data;
	}

	public static void writeResult(String sheetName, int row, String message)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook w = WorkbookFactory.create(fis);
		Sheet s = w.getSheet(sheetName);
		
		s.createRow(row).createCell(0).setCellValue(message);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}

}
