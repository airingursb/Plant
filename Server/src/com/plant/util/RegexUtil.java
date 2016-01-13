package com.plant.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

	//private static String chineseRegex = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";   
	private static String userAccountRegex = "^1\\d{10}$"; 
	private static String userNameRegex = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]{2,10}$";  
	private static String userPasswordRegex = "^[a-zA-Z\\d]{6,}$";
	private static String userPhoneRegex = "^1\\d{10}$";
	private static String userQqRegex = "^[1-9][0-9]{4,}$";
	private static String userWechatRegex = "^[a-zA-Z\\d_\\-]{5,}$";
	
	/**
	 * 错误码1001
	 * @param userAccount
	 * @return
	 */
	public boolean regexUserAccount(String userAccount){
		Pattern pattern = Pattern.compile(userAccountRegex);  
		Matcher matcher = pattern.matcher(userAccount);
		if(matcher.matches()){
			System.out.println("Regex Succeed!");
			return true;
		}else{
			System.out.println("Regex Failed!");
		}
		return false;
	}
	
	/**
	 * 错误码1002
	 * @param userName
	 * @return
	 */
	public boolean regexUserName(String userName){
		Pattern pattern = Pattern.compile(userNameRegex);  
		Matcher matcher = pattern.matcher(userName);
		if(matcher.matches()){
			System.out.println("Regex Succeed!");
			return true;
		}else{
			System.out.println("Regex Failed!");
		}
		return false;
	}
	
	/**
	 * 错误码1003
	 * @param userPassword
	 * @return
	 */
	public boolean regexUserPassword(String userPassword){
		Pattern pattern = Pattern.compile(userPasswordRegex);  
		Matcher matcher = pattern.matcher(userPassword);
		if(matcher.matches()){
			System.out.println("Regex Succeed!");
			return true;
		}else{
			System.out.println("Regex Failed!");
		}
		return false;
	}
	
	/**
	 * 错误码1004
	 * @param userPhone
	 * @return
	 */
	public boolean regexUserPhone(String userPhone){
		Pattern pattern = Pattern.compile(userPhoneRegex);  
		Matcher matcher = pattern.matcher(userPhone);
		if(matcher.matches()){
			System.out.println("Regex Succeed!");
			return true;
		}else{
			System.out.println("Regex Failed!");
		}
		return false;
	}
	
	/**
	 * 错误码1005
	 * @param userQq
	 * @return
	 */
	public boolean regexUserQq(String userQq){
		Pattern pattern = Pattern.compile(userQqRegex);  
		Matcher matcher = pattern.matcher(userQq);
		if(matcher.matches()){
			System.out.println("Regex Succeed!");
			return true;
		}else{
			System.out.println("Regex Failed!");
		}
		return false;
	}
	
	/**
	 * 错误码1006
	 * @param userWechat
	 * @return
	 */
	public boolean regexUserWechat(String userWechat){
		Pattern pattern = Pattern.compile(userWechatRegex);  
		Matcher matcher = pattern.matcher(userWechat);
		if(matcher.matches()){
			System.out.println("Regex Succeed!");
			return true;
		}else{
			System.out.println("Regex Failed!");
		}
		return false;
	}
	
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(userNameRegex);  
		Matcher matcher = pattern.matcher("邓国雄");
		if(matcher.matches()){
			System.out.println("Regex Succeed!");
		}else{
			System.out.println("Regex Failed!");
		}
	}
}
