package springboot.test_springboot.utils;

import java.util.Random;

public class RandomString {
	//方法1：length为产生的位数
	public static String getRandomString(int length) {
		//定义一个字符串（A-Z,a-z,0-9）即62位
		String str="zxcvbnmasdfghjklqwertyuiopZXCVBNMASDFGHJKLQWERTYUIOP1234567890";
		Random random=new Random();
		//System.out.println(random.);
		StringBuffer sb=new StringBuffer();
		//长度为几就循环几次
		for(int i=0; i<length; i++) {
			int number=random.nextInt(62);
			System.out.println(number);
			sb.append(str.charAt(number));
			
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		//String str=getRandomString(3);
		//System.out.println(str);
		String str=getRadomString2(3);
		System.out.println(str);
	}

/*
 * 第二种方法
 * */
	public static String getRadomString2(int length) {
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<length; i++) {
			int number=random.nextInt(3);
			long result=0;
			switch (number) {
			case 0:
				//产生A-Z的ASCII码
				double d=Math.random();
				System.out.println(d);
				result=Math.round(d*25+65);
				sb.append(String.valueOf((char)result));
				break;
			case 1:
				//产生a-z的ASCII码
				double d2=Math.random();
				System.out.println(d2);
				result=Math.round(d2*25+65);
				sb.append(String.valueOf((char)result));
				break;
			case 2:
				//产生0-9的数字
				result=Math.round(Math.random()*25+65);
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;	
			default:
				break;
			}
			
		}
		return sb.toString();
	}
	
	
	public static String getCode(int length) {
		String str="ZXCVBNMASDFGHJKLQWERTYUIOP";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<length; i++) {
			int number=random.nextInt(26);
			sb.append(str.charAt(number));
			
			
			}
		return sb.toString();
		
	}
	
}
