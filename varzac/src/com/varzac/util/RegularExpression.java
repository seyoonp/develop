package com.varzac.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression 
{
	/** 고객 비밀번호 패턴 <br>
	 * 1. 8~12자, 영문(대 소문자 모두 허용)/숫자/특문 포함 <br>
	 * 2. “”-+/\:; 제외 <br>
	 * 3. 동일 문자 3개까지만 허용 <br>
	 * 4. 공백 제외
	 *  @param String 비밀번호
	 *  @return boolean 결과(true=비밀번호 변경가능, false=비밀번호 변경불가)
	 * */
	public static boolean customerPasswordPattern(String password) 
	{
		boolean result = false;
		String passwordPattern = "^(?=.*\\d)(?=.*[!@#$%^&*()_=\\[\\]{}|,.<>?~`])(?=.*[A-Za-z]).{8,12}$";
		String passwordContinuousPattern = "(.)\\1\\1\\1";
		String passwordEtcPattern = "^[^+\\-;':\"\\\\/]+$";
		Matcher matcher = Pattern.compile(passwordPattern).matcher(password);
		Matcher matcherEtc = Pattern.compile(passwordEtcPattern).matcher(password);
		Matcher matcherContinuous = Pattern.compile(passwordContinuousPattern).matcher(password);

		// 고객 비밀번호 정규식 패턴 만족시
		if(matcher.matches()) {
			result = true;
		}
		
		// 고객 비밀번호 특정문자 제외
		if(matcherEtc.matches() == false) {
			result = false; 
		}
		
		// 같은 문자 3개 까지만 사용
		if(matcherContinuous.find()){
			result = false;
		}
		
		// 공백 포함시
		if(password.contains(" ")){
			result = false;
		}
		
		return result;
	}
	

}
