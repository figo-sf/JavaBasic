package com.figo.jeecg;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

class A {
    A() {
    }

    public static void main(String[] args) throws UnknownHostException, SocketException {
        System.out.println("本机MAC地址:" + s());
    }

    private static String q() {
        String returnMac = "";
        byte[] mac = (byte[])null;

        try {
            InetAddress ia = InetAddress.getLocalHost();
            mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        } catch (Exception var7) {
            return null;
        }

        StringBuffer sb = new StringBuffer("");
        if(mac == null) {
            return null;
        } else {
            for(int i = 0; i < mac.length; ++i) {
                if(i != 0) {
                    sb.append("-");
                }

                int temp = mac[i] & 255;
                String str = Integer.toHexString(temp);
                if(str.length() == 1) {
                    sb.append("0" + str);
                } else {
                    sb.append(str);
                }
            }

            returnMac = sb.toString().toUpperCase();
            if("".equals(returnMac)) {
                return null;
            } else {
                return returnMac;
            }
        }
    }

    private static String r() {
        String mac_s = "";

        try {
            Enumeration el = NetworkInterface.getNetworkInterfaces();

            while(true) {
                byte[] mac;
                do {
                    if(!el.hasMoreElements()) {
                        return mac_s;
                    }

                    mac = ((NetworkInterface)el.nextElement()).getHardwareAddress();
                } while(mac == null);

                StringBuilder builder = new StringBuilder();
                byte[] var7 = mac;
                int var6 = mac.length;

                for(int var5 = 0; var5 < var6; ++var5) {
                    byte b = var7[var5];
                    builder.append(a(b));
                    builder.append("-");
                }

                builder.deleteCharAt(builder.length() - 1);
                mac_s = builder.toString().toUpperCase();
            }
        } catch (Exception var8) {
            var8.printStackTrace();
            return mac_s;
        }
    }

    private static String a(byte b) {
        String s = "000000" + Integer.toHexString(b);
        return s.substring(s.length() - 2);
    }

    private static String j() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static String s() {
        String os = j();
        String mac = null;
        if(os.startsWith("windows")) {
            mac = q();
        } else {
            mac = r();
        }

        return mac;
    }
}
