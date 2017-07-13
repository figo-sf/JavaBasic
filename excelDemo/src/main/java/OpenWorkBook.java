/**
 * Created by 50245 on 2017/7/12.
 */

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class OpenWorkBook {
    public static void main(String args[]) throws Exception {
        File file = new File("createworkbook.xlsx");
        FileInputStream fIP = new FileInputStream(file);
        //Get the workbook instance for XLSX file
        XSSFWorkbook workbook = new XSSFWorkbook(fIP);
        if (file.isFile() && file.exists()) {
            System.out.println(
                    "createworkbook.xlsx file open successfully.");
        } else {
            System.out.println(
                    "Error to open createworkbook.xlsx file.");
        }
    }
}