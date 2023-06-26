package com.figo;


import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfWriter;
import com.microsoft.playwright.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        //writePic(test(false));
        test3();
    }

    public static byte[] test(boolean end) {
        String executablePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        Map<String, String> map = new HashMap();
        map.put("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");
        Playwright.CreateOptions createOptions = new Playwright.CreateOptions();
        createOptions.setEnv(map);
        try (Playwright playwright = Playwright.create(createOptions)) {
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            //launchOptions.executablePath = Paths.get(executablePath);
            launchOptions.chromiumSandbox = true;
            launchOptions.headless = true;

            Browser browser = playwright.chromium().launch(launchOptions);
            Page page = browser.newPage();
            page.setViewportSize(1920, 1080 * 3);
            page.navigate("https://tsp-ui-mobility-dev.alliance-rd.com.cn/#/report");
            //page.navigate("https://www.quackit.com/html/templates/download/preview.cfm?template=../frames/css_frames/frames_2_column_left_menu.cfm#");
            Page.ScreenshotOptions options = new Page.ScreenshotOptions();
//            //ElementHandle.ScreenshotOptions options = new ElementHandle.ScreenshotOptions();
//            Path p = Paths.get("a2.png");
//            options.path = p;
//            options.setFullPage(true);
            //page.querySelector("#lg").screenshot(options);
            System.out.println(LocalDateTime.now());
            Thread.sleep(3 * 1000);
            if (end) {
                page.mouse().wheel(0, 100000);
            }
            System.out.println(page.viewportSize().height);
            byte[] bt = page.screenshot();
            return bt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writePic(byte[] bt) {
        ByteArrayInputStream in = new ByteArrayInputStream(bt);    //将b作为输入流；
        try {
            BufferedImage image = ImageIO.read(in);
            File picture = new File("111111.png");
            ImageIO.write(image, "png", picture);
            in.close();
        } catch (Exception e) {

        }
    }

    public static byte[] byteMerger(byte[] bt1, byte[] bt2) {

        byte[] bt3 = new byte[bt1.length + bt2.length];
        System.arraycopy(bt1, 0, bt3, 0, bt1.length);
        System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
        return bt3;
    }

    public static void test1() {
        String executablePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        Map<String, String> map = new HashMap();
        map.put("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");
        Playwright.CreateOptions createOptions = new Playwright.CreateOptions();
        createOptions.setEnv(map);
        try (Playwright playwright = Playwright.create(createOptions)) {
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.executablePath = Paths.get(executablePath);
            launchOptions.chromiumSandbox = true;
            Browser browser = playwright.chromium().launch(launchOptions);
            Page page = browser.newPage();

            page.navigate("https://tsp-ui-mobility-dev.alliance-rd.com.cn/#/report");

            Page.PdfOptions options = new Page.PdfOptions();
            Path p = Paths.get("a1.png");
            options.path = p;
            //page.waitForResponse();
            page.pdf(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.channel = "msedge";
            Browser browser = playwright.chromium().launch(launchOptions);
            Page page = browser.newPage();

            page.navigate("https://baidu.com");

            ElementHandle.ScreenshotOptions options = new ElementHandle.ScreenshotOptions();
            Path p = Paths.get("a.png");
            options.path = p;
            page.querySelector("#lg").screenshot(options);
            System.out.println();
        }
    }


    public static void test3() {
        Map<String, String> map = new HashMap();
        map.put("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");
        Playwright.CreateOptions createOptions = new Playwright.CreateOptions();
        createOptions.setEnv(map);

        try (Playwright playwright = Playwright.create(createOptions)) {
            String wss = "wss://chromeless-ads-dev.alliance-rd.com.cn/";
            // String wss="wss://chrome-mobility-dev.alliance-rd.com.cn";
            Browser browser = playwright.chromium().connectOverCDP(wss);
            Page page = browser.newPage();
            //page.setViewportSize(842, 595);
            page.setViewportSize(1920, 1080);
            try {
                page.navigate("https://ads-ui-ads-dev.alliance-rd.com.cn/#/monthReport/detailPDF?monthDate=2022-11-01&userId=9");
                Thread.sleep(4 * 1000);

                Page.ScreenshotOptions options = new Page.ScreenshotOptions();
                Path p = Paths.get("a555.png");
                options.path = p;
           /* options.displayHeaderFooter = false;
            //options.format = "A4";
            options.height = "8.27in";
            //options.height="11.7in";
            options.width = "11.7in";
            options.printBackground  = true;

            options.landscape = false;*/
                ;

                Image image = Image.getInstance(page.screenshot(options));
                float height = image.getHeight();
                float width = image.getWidth();
                int percent = getPercent(height, width);
                //生成指定宽高的pdf文件
                Document document = new Document(new Rectangle(1920, 1080));
                document.setMargins(0, 0, 0, 0);
                //Document document = new Document(PageSize.A4.rotate(), 0, 0, 50, 0);
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("123.pdf"));
                writer.setPdfVersion(PdfName.P);
                document.open();
                //将图片放入pdf文件
                image.setAlignment(Image.MIDDLE);
                //image.scalePercent(percent);
                document.add(image);
                System.out.println("PageSize: "+document.getPageSize().toString());
                document.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 等比压缩，获取压缩百分比
     *
     * @param height 图片的高度
     * @param weight 图片的宽度
     * @return 压缩百分比
     */
    private static int getPercent(float height, float weight) {
        float percent = 0.0F;
        if (height < weight) {
            percent = PageSize.A4.getHeight() / weight * 100;
        } else {
            percent = PageSize.A4.getWidth() / height * 100;
        }
        return Math.round(percent);
    }
}