package com.haogrgr.algorithm.utils;

public class Strings {

	public static String blanks(int size) {
		if (size <= 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

}
