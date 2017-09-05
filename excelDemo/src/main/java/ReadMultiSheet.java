import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 50245 on 2017/8/15.
 */
public class ReadMultiSheet {
    static XSSFRow row;
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis = new FileInputStream(
                new File("WriteSheet.xlsx"));

        System.out.println(readExcelSheetContent(fis).size());
        fis.close();
    }

    /**
     *
     * @param fis excel文件流
     * @return 多工作薄 Map<工作薄名, 行list> 每行list是Map<列号, 值>
     */

    public static Map<String, List<?>> readExcelSheetContent(InputStream fis) throws IOException, InvalidFormatException {
       Map<String, List<?>> sheetContent = new HashMap<String, List<?>>();//多工作薄


            Workbook workbook = WorkbookFactory.create(fis);

            int j = 0;

            while (hasNextShoot(workbook,j)) {

                Sheet spreadsheet = workbook.getSheetAt(j);
                System.out.println(spreadsheet.getSheetName());


                j++;

            }


        return sheetContent;
    }

    private static boolean hasNextShoot(Workbook workbook, int i){

        boolean falg= true;
        try {
            Sheet spreadsheet = workbook.getSheetAt(i);
        }catch (Exception e){
            falg= false;
        }

        return falg;
    }
}
