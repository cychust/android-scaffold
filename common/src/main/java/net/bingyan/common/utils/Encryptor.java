package net.bingyan.common.utils;

import android.support.annotation.StringDef;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     21:38
 * Email    xinliugm@gmail.com
 */

public class Encryptor {
    private static final String MD5 = "MD5";
    private static final String SHA1 = "SHA-1";
    private static final String SHA224 = "SHA-224";
    private static final String SHA256 = "SHA-256";
    private static final String SHA384 = "SHA-384";
    private static final String SHA512 = "SHA-512";

    @StringDef({MD5, SHA1, SHA224, SHA256, SHA384, SHA512})
    private @interface Alg {
    }

    public static String encrypt(String origin, @Alg String alg) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(alg);
            messageDigest.update(origin.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
