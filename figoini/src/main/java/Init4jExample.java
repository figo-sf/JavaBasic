/**
 * @Auther: figo sffchxd@qq.com
 * @Date: 2018/11/14 09:00
 * @Description: //todo
 */
import org.apache.commons.lang3.StringUtils;
import org.ini4j.Config;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <pre>
 * Init4jExample.java
 * @author kanpiaoxue<br>
 * @version 1.0
 * Create Time 2014年7月5日 下午12:43:04<br>
 * Description : init4j 的使用
 * </pre>
 */
public class Init4jExample {
    private static final String CONFIG_NAME = "hello.ini";
    private static final String SYSTEM = "system";
    private static final String COMPANY = "company";
    private static final String PROGRAM_NAME = "program_name";
    private static final String VERSION = "version";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String SEX = "sex";
    private static final String ADDRESS = "address";

    /**经·
     * <pre>
     * @param args
     * </pre>
     */
    public static void main(String[] args) {

        Config cfg = new Config();
        // 生成配置文件的URL
        URL url = Resources.getResource(CONFIG_NAME);
        // 设置Section允许出现重复
        cfg.setMultiSection(true);
        Ini ini = new Ini();
        ini.setConfig(cfg);
        try {
            // 加载配置文件
            ini.load(url);
            System.out.println(StringUtils.center(SYSTEM, 50, '='));
            // 读取 system
            Section section = ini.get(SYSTEM);
            System.out.println(PROGRAM_NAME + " : " + section.get(PROGRAM_NAME));
            System.out.println(VERSION + " : " + section.get(VERSION));

            // 读取没有规律的person系列
            System.out.println(StringUtils.center("person", 50, '='));
            Set<Entry<String, Section>> set = ini.entrySet();
            for (Entry<String, Section> entry : set) {
                String sectionName = entry.getKey();
                // 跳过 system 和 company
                if (!SYSTEM.equals(sectionName) && !COMPANY.equals(sectionName)) {
                    System.out.println(NAME + " : " + entry.getValue().get(NAME));
                    System.out.println(AGE + " : " + entry.getValue().get(AGE));
                    System.out.println(SEX + " : " + entry.getValue().get(SEX));
                }
            }

            // 读取具有相同 Section 的 company
            System.out.println(StringUtils.center(COMPANY, 50, '='));
            for (Section session : ini.getAll(COMPANY)) {
                System.out.println(NAME + " : " + session.get(NAME));
                System.out.println(ADDRESS + " : " + session.get(ADDRESS));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}