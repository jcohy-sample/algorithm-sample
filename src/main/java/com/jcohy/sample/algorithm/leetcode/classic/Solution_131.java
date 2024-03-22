package com.jcohy.sample.algorithm.leetcode.classic;

import org.springframework.util.StopWatch;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_131 {


	static class PalindromePartitioning {
		public List<List<String>> partition(String s) {
			List<List<String>> result = new ArrayList<>();
			backtrack(s,0,new ArrayList<>(),result);
			return result;
		}

		/**
		 * 通过回溯算法递归地搜索所有可能的分割方案。
		 * 回文串分割的问题使用回溯算法来解决，其时间复杂度取决于所有可能的回文分割方案的数量。这里我们来分析一下时间复杂度：
		 * 假设输入的字符串长度为 n。
		 * 在最坏情况下，字符串没有重复的字符且都为相同字符（例如 “aaaaa”），则可能的分割方案数为 2^n-1，因为对于长度为 n 的字符串，我们可以选择把每一个字符作为一个回文子串分割点，也可以选择不分割，所以共有 2^(n-1) 种分割情况。
		 * 对于每种分割情况，我们需要检查回文性，其时间复杂度为 O(n)，因此总体时间复杂度为 O(2^n * n)。
		 * 值得一提的是，虽然看起来时间复杂度很高，但是实际上很多分支是可以被剪枝的，因此实际运行时间可能会比较快。如果您有大量数据需要处理，可以考虑使用动态规划来优化算法。
		 *
		 * @param s
		 * @param start
		 * @param path
		 * @param result
		 */
		private void backtrack(String s, int start,List<String> path, List<List<String>> result) {
			if(start == s.length()) {
				result.add(new ArrayList<>(path));
				return;
			}

			for (int end = start + 1; end <=s.length(); end ++) {
				if(isPalindrome(s.substring(start,end))) {
					path.add(s.substring(start,end));
					backtrack(s,end,path,result);
					path.remove(path.size() -1);
				}
			}
		}

		private boolean isPalindrome(String s) {
			int left = 0;
			int right = s.length() - 1;

			while (left < right) {
				if(s.charAt(left) != s.charAt(right)) {
					return false;
				}

				left ++;
				right --;
			}
			return true;
		}
	}


	/**
	 * 对回文串分割问题进行优化的一个主要思路是使用动态规划来避免重复计算回文性。下面是一个使用动态规划优化回文串分割算法的 Java 示例代码：
	 * 在这个优化后的算法中，我们首先使用一个动态规划数组 dp 来记录字符串中各个子串是否是回文串。在回溯时，只有当当前子串是回文串时才进行递归搜索，避免重复计算回文性。
	 * 通过这种优化，我们避免了重复的回文性判断，提高了效率。这样修改后的算法在时间复杂度上仍然是 O(2^n * n)，但是实际运行时会比未优化前的算法更快。希望这个优化算法对您有所帮助！如果您有任何问题，欢迎随时提问。
	 *
	 */
	static class OptimizedPalindromePartitioning{
		public List<List<String>> partition(String s) {
			List<List<String>> result = new ArrayList<>();
			boolean[][] dp = new boolean[s.length()][s.length()];

			for (int end = 0; end < s.length(); end++) {
				for (int start = 0; start <= end; start++) {
					if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
						dp[start][end] = true;
					}
				}
			}

			backtrack(s, 0, new ArrayList<>(), result, dp);
			return result;
		}

		private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {
			if (start == s.length()) {
				result.add(new ArrayList<>(path));
				return;
			}

			for (int end = start; end < s.length(); end++) {
				if (dp[start][end]) {
					path.add(s.substring(start, end + 1));
					backtrack(s, end + 1, path, result, dp);
					path.remove(path.size() - 1);
				}
			}
		}
	}

	/**
	 * 除了使用回溯算法和动态规划来解决回文串分割问题之外，还有一种常见的方法是使用广度优先搜索（BFS）来实现。下面是一个使用 BFS 解决回文串分割问题的 Java 示例代码：
	 * 在这个使用 BFS 的算法中，我们使用队列来存储待处理的可能分割方案，不断进行拆分和检查回文性。通过这种方式，我们可以一层一层地向下搜索所有可能的分割方案，直到找到满足条件的回文串分割方案为止。
	 * BFS 在处理回文串分割问题时可能会更快，因为它可以避免一些不必要的计算和递归。希望这个使用 BFS 的算法可以为您提供另一种解决回文串分割问题的思路。如果您有任何问题或需要进一步的解释，请随时告诉我！
	 *
	 * 对于使用 BFS 解决回文串分割问题的算法，让我们来分析一下其时间复杂度：
	 * 假设输入的字符串长度为 n。
	 * 在最坏情况下，假设输入字符串中的每个子串都是回文串，那么最终可能存在指数级的结果。每次迭代中，我们会将当前字符串拆分成多个前缀和后缀，并依次检查是否为回文串，然后将新的分割方案加入队列。因此，在最坏情况下，时间复杂度可以达到指数级别，即 O(2^n)。
	 * 同时，空间复杂度方面，使用了队列来存储待处理的分割方案，因此空间复杂度也是指数级别的，达到 O(2^n)。
	 * 尽管 BFS 算法在某些情况下速度更快，但在最坏情况下，仍然可能需要指数级的时间和空间复杂度。因此，对于较大的输入，仍然可能会面临效率方面的挑战。
	 * 希望以上分析能帮助您更好地理解使用 BFS 解决回文串分割问题的算法复杂度。如果您有任何其他问题，请随时提出！
	 */
	static class BFSPalindromePartitioning {
		public List<List<String>> partition(String s) {
			List<List<String>> result = new ArrayList<>();
			Queue<List<String>> queue = new LinkedList<>();
			List<String> init = new ArrayList<>();
			init.add(s);
			queue.offer(init);

			while (!queue.isEmpty()) {
				List<String> currentList = queue.poll();
				String currentString = currentList.get(currentList.size() - 1);

				if (isPalindrome(currentString)) {
					result.add(new ArrayList<>(currentList));
				}

				for (int i = 1; i < currentString.length(); i++) {
					String prefix = currentString.substring(0, i);
					String suffix = currentString.substring(i);

					if (isPalindrome(prefix)) {
						List<String> newList = new ArrayList<>(currentList);
						newList.set(newList.size() - 1, prefix);
						newList.add(suffix);
						queue.offer(newList);
					}
				}
			}

			return result;
		}

		private boolean isPalindrome(String s) {
			int left = 0;
			int right = s.length() - 1;
			while (left < right) {
				if (s.charAt(left) != s.charAt(right)) {
					return false;
				}
				left++;
				right--;
			}
			return true;
		}
	}

	/**
	 * 除了回溯、动态规划和广度优先搜索之外，还有一种更快速的算法来解决回文串分割问题，即使用回溯算法结合记忆化搜索（Memoization）或称为递归加缓存的技巧。这种方法可以减少不必要的重复计算，从而提高算法的效率。下面是一个使用回溯算法和记忆化搜索的 Java 示例代码：
	 *
	 * 在使用记忆化搜索的方法中，我们使用一个 HashMap 来存储从某个位置开始的回文串分割结果，避免重复计算子问题。这样可以大大提高效率，减少不必要的重复计算。
	 * 这种方法虽然在时间和空间复杂度上仍然是指数级的，但由于记忆化搜索的优化，实际运行时往往速度会更快。希望这种使用记忆化搜索的算法对您有所帮助！如果您有任何其他问题，请随时告诉我。
	 * 对于使用回溯算法结合记忆化搜索（Memoization）解决回文串分割问题的算法，让我们来分析一下其时间复杂度：
	 * 假设输入的字符串长度为 n。
	 * 在最坏情况下，即所有的子串都是回文串时，每种分割方案都会被计算一次，而记忆化搜索可以避免重复计算。因此，虽然时间复杂度仍然是指数级的，但在实际运行中相对于纯回溯算法要快得多。
	 * 因此，在使用记忆化搜索的算法中，对于每个位置，我们最多需要计算和存储指数级别的结果，但由于记忆化搜索的优化，实际计算时间会明显减少。
	 * 因此，回文串分割问题在使用回溯算法结合记忆化搜索的情况下，在最坏情况下仍然具有指数级别的时间复杂度，但在实际运行中会因为避免重复计算而有所优化。
	 * 在空间复杂度方面，由于需要存储每个位置的计算结果，因此空间复杂度也是指数级别的，达到 O(2^n)。
	 */
	static class MemoizationPalindromePartitioning {
		public List<List<String>> partition(String s) {
            Map<Integer, List<List<String>>> memo = new HashMap<>();
			return backtrack(s, 0, memo);
		}

		private List<List<String>> backtrack(String s, int start, Map<Integer, List<List<String>>> memo) {
			if (memo.containsKey(start)) {
				return new ArrayList<>(memo.get(start));
			}

			List<List<String>> result = new ArrayList<>();
			if (start == s.length()) {
				result.add(new ArrayList<>());
				return result;
			}

			for (int end = start + 1; end <= s.length(); end++) {
				String substring = s.substring(start, end);
				if (isPalindrome(substring)) {
					List<List<String>> partitions = backtrack(s, end, memo);
					for (List<String> partition : partitions) {
						List<String> currentPartition = new ArrayList<>(partition);
						currentPartition.add(0, substring);
						result.add(currentPartition);
					}
				}
			}

			memo.put(start, new ArrayList<>(result));
			return result;
		}

		private boolean isPalindrome(String s) {
			int left = 0;
			int right = s.length() - 1;
			while (left < right) {
				if (s.charAt(left) != s.charAt(right)) {
					return false;
				}
				left++;
				right--;
			}
			return true;
		}
	}


	public static void main(String[] args) {

		check("aab");
		check("acdcdcdad");

	}

	public static void check(String s) {
		PalindromePartitioning pp = new PalindromePartitioning();
		OptimizedPalindromePartitioning opp = new OptimizedPalindromePartitioning();
		BFSPalindromePartitioning bfs = new BFSPalindromePartitioning();
		MemoizationPalindromePartitioning mpp = new MemoizationPalindromePartitioning();
		StopWatch watch = new StopWatch();
		watch.start("pp");
		System.out.println(pp.partition(s));
		watch.stop();
		watch.start("opp");
		System.out.println(opp.partition(s));
		watch.stop();
		watch.start("bfs");
		System.out.println(bfs.partition(s));
		watch.stop();
		watch.start("mpp");
		System.out.println(mpp.partition(s));
		watch.stop();;
		System.out.println(watch.prettyPrint());
	}
}
