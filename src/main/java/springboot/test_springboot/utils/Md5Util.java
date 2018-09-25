package springboot.test_springboot.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.Base64Utils;

public class Md5Util {
	 public static String EncoderByMd5(String str){
		    //确定计算方法
		    MessageDigest md5;
			try {
				md5 = MessageDigest.getInstance("MD5");
//				 Encoder base64 = Base64.getEncoder();
				    //加密后的字符串
				   byte[] md5str = md5.digest(str.getBytes("utf-8"));
//					String newstr=base64.encodeToString(md5str);
				    String newstr=Base64Utils.encodeToString(md5str);
				    return newstr;
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return null;
		  }
	 public static void main(String[] args) {
		String str="123";
		String md5str=EncoderByMd5(str);
		String md5str1=EncoderByMd5(str);
		System.out.println(md5str);
		System.out.println(md5str1);
	}

}
