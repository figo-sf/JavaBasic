/**
 * Created by 50245 on 2017/7/11.
 */
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fan on 15-12-10.
 */
public class FreeMarkerTest {

    public static void main(String[] args) throws IOException, TemplateException {
        StringReader stringReader = new StringReader("userName:${user}; URL:${url};");
        Template template = new Template(null, stringReader, null);

        Map<String, String> map = new HashMap<String, String>();
        map.put("user", "fan");
        map.put("url", "www.fan.org");

        StringWriter stringWriter = new StringWriter();
        template.process(map, stringWriter);


        System.out.println(stringWriter.toString());

    }

}