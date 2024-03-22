package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_131 {

	public static List<List<String>> partition(String s) {
		List<List<String>> arr = new ArrayList<>();
		List<String> stringList = Stream.of(s.split(""))
				.collect(Collectors.toList());
		arr.add(stringList);
		System.out.println(arr);
		return arr;
	}

	public static void main(String[] args) {
		partition("aab");
	}
}
