package com.alpha.wordbreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static boolean wordBreak(String s, List<String> dict) {
		Set<String> wordDict = new HashSet<>(dict);
		boolean cache[] = new boolean[s.length() + 1];
		cache[0] = true; // empty string is valid break
		for (int strLen = 1; strLen < s.length(); strLen++) {
			for (int startIdx = 0; startIdx < strLen; startIdx++) {
				if (cache[startIdx] && wordDict.contains(s.substring(startIdx, strLen))) {
					cache[strLen] = true;
					break; // as we can break it here no need to go further
				}
			}
		}
		return cache[s.length()];
	}

	public static void main(String[] args) {

		List<String> li = new ArrayList<>();

		li.add("cats");

		li.add("dog");
		li.add("sand");
		li.add("and");
		li.add("cat");

		System.out.println(wordBreak("catsandog", li));

	}
}
