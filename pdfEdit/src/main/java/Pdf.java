import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pdf {
    public static void main(String[] args) throws Exception {
        //createAllPdf();
        createTextPDF("d.pdf","hello world");
    }

    /**
     * 抠模板
     * @throws Exception
     */
    public  static  void createAllPdf() throws Exception {
        //填充创建pdf
        PdfReader reader = null;
        PdfStamper stamp = null;
        try {
            reader = new PdfReader("b.pdf");
            SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
            String times = simp.format(new Date()).trim();
            //创建生成报告名称

            File deskFile = new File(times + ".pdf");
            stamp = new PdfStamper(reader, new FileOutputStream(deskFile));
            //取出报表模板中的所有字段
            AcroFields form = stamp.getAcroFields();
            // 填充数据
            form.setField("name", "zhangsan");
            form.setField("age", "15");
            //报告生成日期
            stamp.setFormFlattening(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stamp != null) {
                stamp.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void createTextPDF(String outPath, String content) {
        // 创建文件及相关目录
        File file = new File(outPath);

        Document document = new Document();
        try {
            // 创建PdfWriter对象
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outPath));
            // 设置每行的间距
            writer.setInitialLeading(30);
            // 设置文档属性
            // 作者
            document.addAuthor("feng");
            // 创建日期
            document.addCreationDate();
            // 创建关键字
            document.addKeywords("测试");
            // 创建生产商，自动使用iText
            document.addProducer();
            // 创建程序
            document.addCreator("www.ydc51.com");
            // 标题
            document.addTitle("测试标题");
            // 主题
            document.addSubject("测试PDF创建的主题");

            // 打开文档
            document.open();

            // 方式三：使用iTextAsian.jar中的字体
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont);
            // 设置字体大小
            font.setSize(13);
            // 设置字体颜色
            font.setColor(new BaseColor(255, 0, 0));
            // 设置类型，加粗
            font.setStyle(Font.BOLD);
            // 设置类型，倾斜
            font.setStyle(Font.ITALIC);
            // 设置类型，下划线
            font.setStyle(Font.UNDERLINE);
            // 设置类型，可组合，倾斜+删除线
            font.setStyle(Font.ITALIC | Font.STRIKETHRU);
            // 设置类型，为正常
            font.setStyle(Font.NORMAL);

            // 块
            Chunk chunk = new Chunk("下标");
            // 设置字体，字体定宽
            chunk.setFont(new Font(baseFont, 4));
            // 设置背景颜色
            chunk.setBackground(new BaseColor(0xFF, 0xFF, 0x00));
            // 设置上表下标
            chunk.setTextRise(-3f);

            Paragraph paragraph = new Paragraph(content, font);
            // 试图将一个段落放在同一页中，该方法并不是始终有效
            paragraph.setKeepTogether(true);
            paragraph.add(chunk);
            document.add(paragraph);

            // low level
            PdfContentByte cb = writer.getDirectContent();
            cb.fill();
            cb.sanityCheck();
        } catch (Exception e) {
        } finally {
            // 关闭文档
            document.close();
        }

    }

}
