package security;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class DESUtilUpdate {
    public static Key KEY=null;
    public static String KEY_STRING="abc";

    //产生加密key
    static{
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(KEY_STRING.getBytes());
            generator.init(random);
            KEY=generator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密
     * @param in
     * @return
     */
    public static String encode(String in){
        String out=null;
        try {
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, KEY);
            out= Base64.getUrlEncoder().encodeToString(cipher.doFinal(in.getBytes()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    /**
     * 解密
     * @param in
     * @return
     */
    public static String decode(String in){
        String out=null;
        try {
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, KEY);
            out=new String(cipher.doFinal( Base64.getUrlDecoder().decode(in)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        long currentTimestemp = System.currentTimeMillis() / 1000;

        System.out.println(encode(String.valueOf(currentTimestemp)));//
        System.out.println(encode("123456"));//67pD7puy6t8=
        System.out.println(decode("67pD7puy6t8="));
    }
}