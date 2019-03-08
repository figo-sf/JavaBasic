package com.figo.jeecg;

import java.io.*;
import java.util.Scanner;

/**
 * @Auther: figo sffchxd@qq.com
 * @Date: 2019/2/19 09:34
 * @Description: //todo
 */
public class CpuSerial {
    public static void main(String[] args) {

        System.out.println(j());
        System.out.println(b("cmd /c "+ "ipconfig"+ "/all"));

    }

    private static   String g() {
        String serial = "CPUID000";

        try {
            Process process = Runtime.getRuntime().exec(new String[]{"wmic", "cpu", "get", "ProcessorId"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String property = sc.next();
            serial = sc.next();
        } catch (Exception var4) {
            ;
        }

        return serial;
    }

    private static String h() {
        String result = "ZBXLH000";

        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\nSet colItems = objWMIService.ExecQuery _ \n   (\"Select * from Win32_BaseBoard\") \nFor Each objItem in colItems \n    Wscript.Echo objItem.SerialNumber \n    exit for  ' do the first cpu only! \nNext \n";
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());

            BufferedReader input;
            String line;
            for (input = new BufferedReader(new InputStreamReader(p.getInputStream())); (line = input.readLine()) != null; result = result + line) {
                ;
            }

            input.close();
        } catch (Exception var7) {
            ;
        }

        return result.trim();
    }


    private static String j() {
        return System.getProperty("os.name").toLowerCase();
    }

    private static String b(String execStr) {
        String mac = null;
        BufferedReader bufferedReader = null;
        Process process = null;

        try {
           // process = Runtime.getRuntime().exec("cmd /c " + "ping " + ipAddress + "  -w 1000 -n 2");
            process = Runtime.getRuntime().exec(execStr);
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String line = null;
            boolean var5 = true;

            while((line = bufferedReader.readLine()) != null) {
                if(line.indexOf("本地连接") == -1) {
                    int index = line.toLowerCase().indexOf("物理地址");
                    if(index != -1) {
                        index = line.indexOf(":");
                        if(index != -1) {
                            mac = line.substring(index + 1).trim();
                        }
                        break;
                    }
                }
            }
        } catch (IOException var14) {
            var14.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException var13) {
                var13.printStackTrace();
            }

            bufferedReader = null;
            process = null;
        }

        return mac;
    }
}
