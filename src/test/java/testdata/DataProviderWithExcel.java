package testdata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderWithExcel {

    public String[][] readExcelFile(String filePath, String sheetName){

        String[][] data = null;
        try
        {
            /* Open the file from a given location*/
          //  System.out.println(filePath);
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
                    //System.out.println(cell);
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
        String filePath = System.getProperty("user.dir") + "/src/main/resources/datafiles/data_example.xlsx";
        //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        System.out.println(filePath);
        //Object[][] arrObj =
        return readExcelFile(filePath,"account-test");
    }
    @Test(dataProvider ="excel-data")
    public void search(String user, String password, String role){
        System.out.println("user : " + user + " - " + password + " - with role "+ role);

    }
}
