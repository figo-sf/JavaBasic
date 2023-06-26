package com.figo;



public class RtcTokenBuilder2Sample {
    static String appId = "bb092581132248ca86559f32e753037a";
    static String appCertificate = "8c831761e14f41298a0407f0a11207ac";
    static String channelName = "abc";
    static String account = "123";
    static int uid = 222;
    static int tokenExpirationInSeconds = 3600;
    static int privilegeExpirationInSeconds = 3600;

    public static void main(String[] args) {
        RtcTokenBuilder2 token = new RtcTokenBuilder2();
        String result = token.buildTokenWithUid(appId, appCertificate, channelName, uid, RtcTokenBuilder2.Role.ROLE_SUBSCRIBER, tokenExpirationInSeconds, privilegeExpirationInSeconds);
        System.out.println("Token with uid: " + result);

        result = token.buildTokenWithUserAccount(appId, appCertificate, channelName, account, RtcTokenBuilder2.Role.ROLE_SUBSCRIBER, tokenExpirationInSeconds, privilegeExpirationInSeconds);
        System.out.println("Token with account: " + result);

        result = token.buildTokenWithUid(appId, appCertificate, channelName, uid, privilegeExpirationInSeconds, privilegeExpirationInSeconds, privilegeExpirationInSeconds, privilegeExpirationInSeconds, privilegeExpirationInSeconds);
        System.out.println("Token with uid and privilege: " + result);

        result = token.buildTokenWithUserAccount(appId, appCertificate, channelName, account, privilegeExpirationInSeconds, privilegeExpirationInSeconds, privilegeExpirationInSeconds, privilegeExpirationInSeconds, privilegeExpirationInSeconds);
        System.out.println("Token with account and privilege: " + result);
    }
}
