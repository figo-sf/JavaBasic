/**
 * Created by 50245 on 2017/7/11.
 */
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fan on 15-12-10.
 */
public class FreeMarkerConfiguration {
    public static void main(String[] args) throws IOException, TemplateException {

        String path = FreeMarkerConfiguration.class.getResource("/").getPath();

        File cfgFile = new File(path);

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDirectoryForTemplateLoading(cfgFile);

        Template template = configuration.getTemplate("user.ftl");

        Map<String, String> map = new HashMap<>();
        map.put("name", "fan");
        map.put("message", "hello world!");

        StringWriter stringWriter = new StringWriter();
        template.process(map, stringWriter);
        System.out.println(stringWriter.toString());
    }
}