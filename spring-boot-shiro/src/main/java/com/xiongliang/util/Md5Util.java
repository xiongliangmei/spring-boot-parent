package com.xiongliang.util;

import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Md5Util {
    private static String staticSalt = ".";
    private static  String algorithmName = "MD5";
    private static String encodedPassword = "123456";
    private static String dynaSalt = "admin";

    public static void main(String[] args) {
        ConfigurableHashService hashService = new DefaultHashService();
        hashService.setPrivateSalt(ByteSource.Util.bytes(staticSalt));
        hashService.setHashAlgorithmName(algorithmName);
        hashService.setHashIterations(1024);
        HashRequest request = new HashRequest.Builder()
                .setSalt(dynaSalt)
                .setSource(encodedPassword)
                .build();
        String res =  hashService.computeHash(request).toHex();
        System.out.println(res);

    }
}
