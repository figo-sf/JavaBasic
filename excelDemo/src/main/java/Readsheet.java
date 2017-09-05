/**
 * Created by 50245 on 2017/7/12.
 */
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class Readsheet
{
    static XSSFRow row;
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis = new FileInputStream(
                new File("WriteSheet.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator < Row > rowIterator = spreadsheet.iterator();
        while (rowIterator.hasNext())
        {
            row = (XSSFRow) rowIterator.next();
            Iterator < Cell > cellIterator = row.cellIterator();
            while ( cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellTypeEnum())
                {
                    case NUMERIC:
                        System.out.print(
                                cell.getNumericCellValue() + " \t\t " );
                        break;
                    case STRING:
                        System.out.print(
                                cell.getStringCellValue() + " \t\t " );
                        break;
                }
            }
            System.out.println();
        }
        fis.close();
    }


}