package testdata;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReadExcelFile {
    public String[][] readExcelFile(String filePath, String sheetName){
        String[][] data = null;
        try
        {
            /* Open the file from a given location*/
            FileInputStream file = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(file);

            //Retrieve the sheetName of the file
            XSSFSheet sh = wb.getSheet(sheetName);
            //Retrieve the first sheet of the file
            //Sheet sheet = wb.getSheetAt(0);

            //Retrieve the first row
            XSSFRow row = sh.getRow(0);
            //Retrieve the number of rows and cols
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();

            Cell cell;
            data = new String[noOfRows-1][noOfCols];

            for(int i =1; i<noOfRows;i++){
                for(int j=0;j<noOfCols;j++){
                    row = sh.getRow(i);
                    cell= row.getCell(j);
                    data[i-1][j] = cell.getStringCellValue();
                }
            }
        }
        catch (Exception e) {
            System.out.println("The exception is: " +e.getMessage());
        }
        return data;
    }

    @DataProvider(name ="excel-data")
    public Object[][] excelExample() throws IOException {
        String filePath = System.getProperty("user.dir") + "src/main/resources/datafiles/data_example.xlsx";
        //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        Object[][] arrObj = readExcelFile(filePath,"account-test");
        return arrObj;
    }
    @Test(dataProvider ="excel-data")
    public void search(String user, String password, String role){
        System.out.println("user : " + user + " - " + password + " - with Role "+ role);
    }

    public void writeExcelFileSimple(File fileName, String sheetName){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(sheetName);
        XSSFRow row;
        for (int rowCount=0; rowCount < 4 ; rowCount++){
            row = spreadsheet.createRow(rowCount);
            for (int cellCount = 0; cellCount<5; cellCount++){
                Cell cell = row.createCell(cellCount);
                cell.setCellValue("value at [" + rowCount +"]["+cellCount+"]");
            }
        }
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        try {
            FileOutputStream outputStream =  new FileOutputStream(fileName);
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void writeExcelFile (  Map<String, Object[]> data, File fileName, String sheetName){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet( sheetName);
        XSSFRow row ;

        //Set<String> keyid = data.keySet();

        int rowid = 0;

       // writing the data into the sheets...
        for (String key : data.keySet()) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = data.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeExistingExcelFile(File fileName, String sheetName){
        String[][] data = null;
        String s;
      //  File fileName = new File(filePath);
        try
        {
            /* Open the file from a given location*/
            FileInputStream inputStream = new FileInputStream(fileName);
            //XSSFWorkbook wb = new XSSFWorkbook(file);
            //Creating workbook from input stream
            Workbook wb = WorkbookFactory.create(inputStream);

            //Retrieve the sheetName of the file
            Sheet sh = wb.getSheet(sheetName);
            //Retrieve the first sheet of the file
            //Sheet sheet = wb.getSheetAt(0);

            //Retrieve the first row
            Row row = sh.getRow(0);

            //Retrieve the number of rows and cols
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();

            Cell cell;
            row =sh.getRow(0);
            cell= row.createCell(noOfCols);
            cell.setCellValue("Test Result");

            for(int i =1; i<noOfRows;i++){
                row = sh.getRow(i);
                cell= row.createCell(noOfCols);// row.getCell(j);
                s = String.valueOf(row.getCell(0));
                System.out.println("cell value ="+ row.getCell(0));

                if ("130".equals(s))
                    cell.setCellValue("Passed") ;
                else
                    cell.setCellValue("Failed") ;

            }
            //Close input stream
            inputStream.close();

            //Crating output stream and writing the updated workbook
            FileOutputStream out = null;
            // .xlsx is the format for Excel Sheets...
            // writing the workbook into the file...
            try {
                out = new FileOutputStream(fileName);
                wb.write(out);
                //Close the workbook and output stream
                wb.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Excel file has been updated successfully.");
        }catch (EncryptedDocumentException | IOException e) {
            System.err.println("Exception while updating an existing excel file.");
            e.printStackTrace();
        }
    }

}

