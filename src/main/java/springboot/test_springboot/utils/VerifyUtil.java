package springboot.test_springboot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyUtil {
	
	/**
	 * 手机号校验
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		boolean flag = false;
		try {
 
			// 13********* ,15********,18*********
			Pattern p = Pattern.compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
 
			Matcher m = p.matcher(mobiles);
			flag = m.matches();
 
		} catch (Exception e) {
			flag = false;
		}
 
		return flag;
	}
}
