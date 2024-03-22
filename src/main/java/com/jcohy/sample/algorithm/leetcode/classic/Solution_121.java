package com.jcohy.sample.algorithm.leetcode.classic;

import java.util.Arrays;

public class Solution_121 {

	public static int maxProfit(int[] prices) {
		int min = prices[0];
		int max = 0;
		int temp;
		for (int price : prices) {
			if (price < min) {
				min = price;
			}
			else {
				temp = price - min;
				if (temp > max) {
					max = temp;
				}
			}

		}
		System.out.println(max);
		return max;
	}

	public int maxProfit2(int[] prices) {
		int cost = Integer.MAX_VALUE, profit = 0;
		for(int price:prices){
			cost = Math.min(cost,price);
			profit = Math.max(profit,price-cost);
		}
		return profit;
	}

	public static void main(String[] args) {
		// 5
		maxProfit(new int[]{7,1,5,3,6,4});
		maxProfit(new int[]{1,2});
		maxProfit(new int[]{7,6,4,3,1});
	}
}
