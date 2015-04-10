package com.hungry.leetcode;

public class VersionNumbers {

	public int compareVersion(String version1, String version2) {
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		int len1 = ver1.length;
		int len2 = ver2.length;
		int len = len1 > len2 ? len1 : len2;

		for (int i = 0; i < len; i++) {
			int num1 = i >= len1 ? 0 : Integer.parseInt(ver1[i]);
			int num2 = i >= len2 ? 0 : Integer.parseInt(ver2[i]);
			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		VersionNumbers vn = new VersionNumbers();
		String version1 = "2.3.60.0";
		String version2 = "2.3.60";
		System.out.println(vn.compareVersion(version1, version2));
	}

}
