package coreUtilities.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class FileOperations 
{
	public JSONParser jsonParser;
	public JSONObject jsonObject;
	public Fillo fillo;
	public Connection connection;
	public Properties properties;
	
	/**
     * This method is useful to read the excel sheet based on the Filename and sheet name. It'll return the values for the respective
     * sheet in {@link Map} where the first column name as a key and the value as per the value entered in econd column.
     * @param excelFilePath - {@link String} excel sheet location
     * @param sheetName - {@link String} Sheet name to read the excel
     * @return {@link Map}
     * @throws Exception
     */
	public Map<String, String> readExcelPOI(String excelFilePath, String sheetName) throws Exception {
		Map<String, String> dataMap = new HashMap<>();
		FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);

		DataFormatter formatter = new DataFormatter();

		for (Row row : sheet) {
			Cell keyCell = row.getCell(0);
			Cell valueCell = row.getCell(1);

			if (keyCell != null && valueCell != null) {
				String key = formatter.formatCellValue(keyCell);
				String value = formatter.formatCellValue(valueCell);
				dataMap.put(key, value);
			}
		}
		workbook.close();
		fileInputStream.close();

		return dataMap;
	}

}

