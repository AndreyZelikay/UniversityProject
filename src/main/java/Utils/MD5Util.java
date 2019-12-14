package Utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static String encrypt(String str){
        return DigestUtils.md5Hex(str);
    }
}
