package com.cnten.platform.util;

import java.net.URLDecoder;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;

import javax.crypto.Cipher;

/**
 * RSA 加密 算法
 * @author Administrator
 */
public class RSAUtil {
	public static final java.security.Provider provider = new org.bouncycastle.jce.provider.BouncyCastleProvider();  
	public static final int KEY_LENGTH = 512;
	/** 
     * Generates the Keypair with the given keyLength. 
     *  
     * @param keyLength 
     *            length of key 
     * @return KeyPair object 
     * @throws RuntimeException 
     *             if the RSA algorithm not supported 
     */  
	 public static KeyPair generateKeypair() throws Exception {  
	        try {  
	            KeyPairGenerator kpg;   
	            try {  
	                kpg = (KeyPairGenerator) KeyPairGenerator.getInstance("RSA");  
	            } catch (Exception e) {  
	                kpg = (KeyPairGenerator) KeyPairGenerator.getInstance("RSA",provider);  
	            }  
	            kpg.initialize(KEY_LENGTH);  
	            KeyPair keyPair = kpg.generateKeyPair();  
	            return keyPair;  
	        } catch (NoSuchAlgorithmException e1) {  
	            throw new RuntimeException("RSA algorithm not supported", e1);  
	        } catch (Exception e) {  
	            throw new Exception("RSA encypt exceptions", e);  
	        }  
	    }
	
	 /** 
     * Decrypts a given string with the RSA keys 
     *  
     * @param encrypted 
     *            full encrypted text 
     * @param keys 
     *            RSA keys 
     * @return decrypted text 
     * @throws RuntimeException 
     *             if the RSA algorithm not supported or decrypt operation failed 
     */  
    @SuppressWarnings("deprecation")
	public static String decryptByPrivateKey(String encrypted, RSAPrivateKey privateKey) throws Exception {  
        Cipher dec;  
        try {  
            try {  
                dec = Cipher.getInstance("RSA/NONE/NoPadding");  
            } catch (Exception e) {  
                dec = Cipher.getInstance("RSA/NONE/NoPadding",provider);  
            }  
            
            dec.init(Cipher.DECRYPT_MODE, privateKey);  
        } catch (GeneralSecurityException e) {  
            throw new RuntimeException("RSA algorithm not supported", e);  
        }  
        String[] blocks = encrypted.split("\\s");  
        StringBuffer result = new StringBuffer();  
        try {  
            for (int i = blocks.length - 1; i >= 0; i--) {  
                byte[] data = hexStringToByteArray(blocks[i]);  
                byte[] decryptedBlock = dec.doFinal(data);  
                result.append(new String(decryptedBlock));  
            }  
        } catch (GeneralSecurityException e) {  
            throw new RuntimeException("Decrypt error", e);  
        }  
        /** 
         * Some code is getting added in first 2 digits with Jcryption need to investigate 
         */  
        String finalResult = URLDecoder.decode(result.reverse().toString());
        return finalResult;  
    } 
    
    /** 
     * Convert hex string to byte array 
     *  
     * @param data 
     *            input string data 
     * @return bytes 
     */  
    public static byte[] hexStringToByteArray(String data) {  
        int k = 0;  
        byte[] results = new byte[data.length()/2];  
        for (int i = 0; i < data.length();) {  
            results[k] = (byte) (Character.digit(data.charAt(i++), 16) << 4);  
            results[k] += (byte) (Character.digit(data.charAt(i++), 16));  
            k++;  
        }  
        return results;  
    } 
    
}
