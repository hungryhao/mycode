package com.hungry.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDnaSequences {

	public List<String> findRepeatDnaSequences(String s) {
		List<String> list = new ArrayList<String>();
		if (s.length() <= 10) {
			return list;
		}
		for (int i = 0; i < s.length() - 9; i++) {
			for (int j = i + 1; j < s.length() - 9; j++) {
				String str = s.substring(i, i + 10);
				if (s.subSequence(j, j + 10).equals(str)) {
					list.add(str);
				}
			}
		}
		return list;
	}
	
	public List<String> findRepeatDnaSequences2(String s) {
		List<String> list = new ArrayList<String>();
		if (s.length() <= 10) {
			return list;
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < s.length() - 9; i++) {
			String str = s.substring(i, i + 10);
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			} else {
				map.put(str, 1);
			}
		}
		/*Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, Integer> temp = iterator.next();
			if(temp.getValue()==2) {
				list.add(temp.getKey());
			}
		}*/
		
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String temp = iterator.next();
			if(map.get(temp)==2) {
				list.add(temp);
			}
		}
		
		return list;
	}
	
	public List<String> findRepeatDnaSequences3(String s) {
		Set<Integer> word = new HashSet<Integer>();
		Set<Integer> doublewords = new HashSet<Integer>();
		List<String> list  = new ArrayList<String>();
		char[] map = new char[26];
		map['C'-'A'] = 1;
		map['G'-'A'] = 2;
		map['T'-'A'] = 3;
		for(int i=0; i<s.length()-9; i++) {
			int temp = 0;
			for(int j=i; j<i+10; j++) {
				temp <<= 2;
				temp |= map[s.charAt(j)-'A'];
			}
			if(!word.add(temp) && doublewords.add(temp)) {
				list.add(s.substring(i, i+10));
			}
		}
		return list;
		
	}
	
	public List<String> findRepeatDnaSequences4(String s) {
		List<String> list = new ArrayList<String>();
		if (s.length() <= 10) {
			return list;
		}
		
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < s.length() - 9; i++) {
			String str = s.substring(i, i + 10);
			if(!set.add(str)) {
				list.add(str);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		RepeatedDnaSequences rds = new RepeatedDnaSequences();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		for (String str : rds.findRepeatDnaSequences4(s)) {
			System.out.println(str);
		}
	}

}
