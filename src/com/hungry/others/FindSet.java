package com.hungry.others;

import java.util.ArrayList;
import java.util.List;

public class FindSet {
	public List<Group> findSet(int[] num, int k) {
		int start = 0;
		int end = num.length-1;
		List<Group> list = new ArrayList<Group>();
		while(start < end) {
			for(int temp=start; temp<end; temp++) {
				if(num[temp]+num[end]==k) {
					list.add(new Group(num[temp], num[end]));
				}
			}
			
			end--;
		}
		return list;
	}
	
	public static void main(String[] args) {
		FindSet fs = new FindSet();
		int[] num = {4,5,7,2,3,9};
		int k = 9;
		List<Group> list = fs.findSet(num, k);
		for(Group temp:list) {
			System.out.println(temp.a + " " + temp.b);
		}
		
	}

}

class Group {
	public int a;
	public int b;
	public Group(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
