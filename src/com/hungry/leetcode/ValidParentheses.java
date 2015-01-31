package com.hungry.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		if (null == s) {
			return false;
		}
		if (s.length() % 2 != 0) {
			return false;
		}
		while (s.length() > 0) {
			if (s.contains("(")) {
				int left = s.lastIndexOf("(");
				int right = s.indexOf(")", left);
				if (right > 0) {
					String tmp = s.substring(left + 1, right);
					if (tmp.length() % 2 != 0) {
						return false;
					}
					s = s.substring(0, left) + tmp + s.substring(right + 1);
				} else {
					return false;
				}
			}
			if (s.contains("[")) {
				int left = s.lastIndexOf("[");
				int right = s.indexOf("]", left);
				if (right > 0) {
					String tmp = s.substring(left + 1, right);
					if (tmp.length() % 2 != 0) {
						return false;
					}
					s = s.substring(0, left) + tmp + s.substring(right + 1);
				} else {
					return false;
				}
			}
			if (s.contains("{")) {
				int left = s.lastIndexOf("{");
				int right = s.indexOf("}", left);
				if (right > 0) {
					String tmp = s.substring(left + 1, right);
					if (tmp.length() % 2 != 0) {
						return false;
					}
					s = s.substring(0, left) + tmp + s.substring(right + 1);
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character> ();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c=='(' || c=='[' || c=='{') {
				stack.push(c);
			} else if(c==')' || c==']' || c=='}') {
				if(stack.isEmpty()) {
					return false;
				}
				Character cp = stack.pop();
				if(cp.equals('(') && c==')') {
					continue;
				} else if(cp.equals('[') && c==']') {
					continue;
				} else if(cp.equals('{') && c=='}') {
					continue;
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public boolean isValid3(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}

	public static void main(String[] args) {
		String s = "(({})){()}";
		ValidParentheses vp = new ValidParentheses();
		System.out.println(s.startsWith("{") && s.endsWith("}"));
		System.out.println(s.substring(1, s.length() - 1).length());
		System.out.println(vp.isValid3(s));
	}

}
