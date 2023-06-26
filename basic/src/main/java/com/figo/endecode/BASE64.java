package com.figo.endecode;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * BASE64加密解密   
 */
public class BASE64
{

    /**
     * BASE64解密   
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密   
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    public static void main(String[] args) throws Exception
    {
        String data = BASE64.encryptBASE64("http://aub.iteye.com/".getBytes());
        System.out.println("加密前："+data);

        //byte[] byteArray = BASE64.decryptBASE64(data);
        byte[] byteArray = BASE64.decryptBASE64("aHR0cHM6Ly90ZWFtcy5taWNyb3NvZnQuY29tL2RsL2xhdW5jaGVyL2xhdW5jaGVyLmh0bWw/dXJsPSUyRl8lMjMlMkZsJTJGbWVldHVwLWpvaW4lMkYxOSUzQW1lZXRpbmdfT1dWaU1HTXhZekF0TUdGbE5pMDBZV0ppTFRrNU9EVXROV1UyWWpnME5HUTNOVFUzJTQwdGhyZWFkLnYyJTJGMCUzRmNvbnRleHQlM0QlMjU3YiUyNTIyVGlkJTI1MjIlMjUzYSUyNTIyMzEwOTYyYjItMzM2OS00ZDIwLTg3NjMtY2I1NjFlNWY0YTkyJTI1MjIlMjUyYyUyNTIyT2lkJTI1MjIlMjUzYSUyNTIyOGEzYjdlMjgtNzdlMC00OTliLThmOGYtYzc3NzgyNWQ3MWQ5JTI1MjIlMjU3ZCUyNmFub24lM0R0cnVlJnR5cGU9bWVldHVwLWpvaW4mZGVlcGxpbmtJZD05YTUyMjBiOS02MGIzLTQ0MjEtODVmNS00NTJhMmFlNDgxMzImZGlyZWN0RGw9dHJ1ZSZtc0xhdW5jaD10cnVlJmVuYWJsZU1vYmlsZVBhZ2U9dHJ1ZSZzdXBwcmVzc1Byb21wdD10cnVl");
        System.out.println("解密后："+new String(byteArray));
    }
}    