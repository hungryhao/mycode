package com.hungry.leetcode;

public class ValidParentheses {

	public boolean isValid(String s) {
		if (null == s) {
			return false;
		}
		if (s.length() % 2 != 0) {
			return false;
		}
		while (s.length() > 0) {
			if (s.startsWith("(") && s.contains(")")) {
				s = s.substring(1, s.indexOf(")"));
			} else if (s.startsWith("[") && s.endsWith("]")) {
				s = s.substring(1, s.indexOf("]"));
			} else if(s.startsWith("{") && s.endsWith("}")) {
				s = s.substring(1, s.indexOf("}"));
			} else {
				break;
			}
		}
		if (s.length() == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "()";
		ValidParentheses vp = new ValidParentheses();
		System.out.println(s.startsWith("{") && s.endsWith("}"));
		System.out.println(s.substring(1, s.length() - 1).length());
		System.out.println(vp.isValid(s));
	}

}
