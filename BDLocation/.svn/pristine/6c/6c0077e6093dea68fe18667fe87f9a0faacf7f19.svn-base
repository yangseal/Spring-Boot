package com.cnten.bdlocation.maplayer.util;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.tomcat.util.codec.binary.Base64;

public class PublicKeyReader {
	
	private PublicKey key;
	private String KEY_PATH;
	
	/** 
     * RSA最大加密明文大小 
     */  
    private static final int MAX_ENCRYPT_BLOCK = 117; 
	/**
     * RSA最大解密密文大小 
     */  
    private static final int MAX_DECRYPT_BLOCK = 128;  
	
	private PublicKeyReader() {
		KEY_PATH = PublicKeyReader.class.getResource("").getPath().concat("arcgis-security.publickey");
	}
	
	private static class LazyHolder {
		private static PublicKeyReader INSTANCE = new PublicKeyReader();
	}
	
	public static PublicKeyReader getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	public PublicKey getKey() throws Exception {
		if(key != null) return key;
		File f = new File(KEY_PATH);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		key = kf.generatePublic(spec);
		return key;
	}
	
	 /** 
     * 公钥解密过程 
     * @param cipherData  密文数据 
     * @return 明文 
     * @throws Exception  解密过程中的异常信息 
     */  
	public String decrypt(byte[] cipherData) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, getKey());
		int inputLen = cipherData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段解密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {  
                cache = cipher.doFinal(cipherData, offSet, MAX_DECRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(cipherData, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_DECRYPT_BLOCK;  
        }  
        byte[] decryptedData = out.toByteArray();  
        out.close();  
		return new String(decryptedData);
	}
	
	/** 
     * 公钥加密过程 
     * @param plainTextData  明文数据 
     * @return base64字符串 
	 * @throws InvalidKeyException 
	 * @throws Exception  加密过程中的异常信息 
     */  
	public String encrypt(byte[] plainTextData) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, getKey());
		int inputLen = plainTextData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段加密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {  
                cache = cipher.doFinal(plainTextData, offSet, MAX_ENCRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(plainTextData, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_ENCRYPT_BLOCK;  
        }  
        byte[] encryptedData = out.toByteArray();  
        out.close();
		return Base64.encodeBase64URLSafeString(encryptedData);
	}

}
