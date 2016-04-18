package service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alvin on 3/2/16.
 * 1. Shouldn't instantiate this object, override default constructor.
 */
public class Gravatar {
    private Gravatar(){}
    public static String hex(byte[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i]
                    & 0xFF) | 0x100).substring(1,3));
        }
        return sb.toString();
    }

    public static String md5Hex (String message) {
        try {
            MessageDigest md =
                    MessageDigest.getInstance("MD5");
            String hash = hex (md.digest(message.getBytes("CP1252")));
            return "http://www.gravatar.com/avatar/" + hash + "?s=70";
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

}
