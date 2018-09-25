package springboot.test_springboot.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.Base64Utils;

public class Md5Util2 {
	 
	
	public static String encodeMd5(String str) throws NoSuchAlgorithmException {
		MessageDigest md5;
		md5=MessageDigest.getInstance("Md5");
		try {
			byte[] bstr=md5.digest(str.getBytes("utf-8"));
			String s=Base64Utils.encodeToString(bstr);
			return s;
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
