// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:55:38
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Encrypt.java

package es.ark.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encrypt
{

    public Encrypt()
    {
    }

    public String getEncryptedString(String input, String clave)
        throws Exception
    {
        Cipher ecipher = getHeader(0, clave);
        byte utf8[] = input.getBytes("UTF8");
        byte enc[] = ecipher.doFinal(utf8);
        return (new BASE64Encoder()).encode(enc);
    }

    public String getDeEncryptedString(String input, String clave)
        throws Exception
    {
        Cipher dcipher = getHeader(1, clave);
        byte utf8[] = (new BASE64Decoder()).decodeBuffer(input);
        byte enc[] = dcipher.doFinal(utf8);
        return new String(enc, "UTF8");
    }

    private Cipher getHeader(int mode, String clave)
        throws Exception
    {
        java.security.spec.KeySpec keySpec = new PBEKeySpec(clave.toCharArray(), SALT_BYTES, ITERATION_COUNT);
        javax.crypto.SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
        java.security.spec.AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);
        if(mode == 0)
            cipher.init(1, key, paramSpec);
        else
            cipher.init(2, key, paramSpec);
        return cipher;
    }

    public static final String ALGORITMO = "DES";
    public static final int BYTE = 8;
    private static byte SALT_BYTES[] = {
        -87, -101, -56, 50, 86, 53, -29, 3
    };
    private static int ITERATION_COUNT = 19;

}