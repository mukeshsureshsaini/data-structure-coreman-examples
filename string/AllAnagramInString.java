package com.alpha.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramInString {

	public static List<Integer> findAnagrams(String s, String p) {

		int[] s1Map = new int[26];
		List<Integer> res = new ArrayList<>();
		

		int i;
		for (i = 0; i < p.length(); i++) {
			char ch1 = p.charAt(i);
			s1Map[ch1 - 'a'] += 1;
		}
		
		int x = 0;
		int y = p.length();
		
		while(y <= s.length()) {
			if(isAnagram(s1Map, s.substring(x,y))) {
				res.add(x);
			}
			x++;
			y++;
		}
	
		

		return res;
	}

	private static boolean isAnagram(int[] arr, String str) {
		int[] ch = new int[26];
		for (int i = 0; i < str.length(); i++) {
			ch[str.charAt(i) - 'a'] += 1;
		}
		return Arrays.equals(arr, ch);
	}

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}
}
