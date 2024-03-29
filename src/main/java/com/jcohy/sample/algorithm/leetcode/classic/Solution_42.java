package com.jcohy.sample.algorithm.leetcode.classic;

import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Stack;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * @author jiac
 * @version 2023.0.1 2024/3/29:23:55
 * @since 2023.0.1
 */
public class Solution_42 {

    /**
     * 1、首先，初始化两个数组leftMax和rightMax，用于分别存储每个位置左侧和右侧的最大高度。
     * 2、从左向右遍历柱子高度数组，计算每个位置左侧的最大高度并存储在leftMax数组中。
     * 3、从右向左遍历柱子高度数组，计算每个位置右侧的最大高度并存储在rightMax数组中。
     * 4、遍历每个位置，计算当前位置上的接水量，即min(leftMax[i], rightMax[i]) - height[i]，并累加到总的接水量中。
     * 5、最终返回总的接水量。
     *
     * 该算法需要遍历柱子高度数组三次，因此时间复杂度为O(n)。
     * 需要额外的空间存储左侧和右侧的最大高度，因此空间复杂度为O(n)。
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n]; // 用于存储当前位置左侧的最大高度
        int[] rightMax = new int[n]; // 用于存储当前位置右侧的最大高度

        // 计算每个位置左侧的最大高度
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 计算每个位置右侧的最大高度
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0; // 存储总的接水量

        // 计算每个位置上的接水量
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }


    /**
     * 双指针法。
     *
     * 1、初始化左指针left为数组起始位置，右指针right为数组末尾位置，左侧最大高度leftMax和右侧最大高度rightMax为0。
     * 2、使用双指针向中间遍历柱子高度数组。
     * 3、在遍历过程中，不断更新左侧和右侧的最大高度。
     * 4、如果左侧的最大高度小于右侧的最大高度，计算当前位置的接水量并移动左指针；否则，计算当前位置的接水量并移动右指针。
     * 5、最终返回总的接水量。
     * 该算法只需遍历一次柱子高度数组，因此时间复杂度为O(n)。
     * 该解法只需要常数级别的额外空间用于存储指针和最大高度，因此空间复杂度为O(1)。
     * 这种双指针的解法在空间复杂度上相比前面的解法有所优化，是更优秀的解法之一。
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0; // 左指针
        int right = n - 1; // 右指针
        int leftMax = 0; // 左侧最大高度
        int rightMax = 0; // 右侧最大高度
        int water = 0; // 存储总的接水量

        // 双指针遍历柱子高度数组
        while (left < right) {
            // 更新左侧最大高度
            leftMax = Math.max(leftMax, height[left]);
            // 更新右侧最大高度
            rightMax = Math.max(rightMax, height[right]);
            // 如果左侧的最大高度小于右侧的最大高度，计算当前位置的接水量并移动左指针
            if (leftMax < rightMax) {
                water += leftMax - height[left];
                left++;
            }
            // 否则，计算当前位置的接水量并移动右指针
            else {
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }


    /**
     * 1、初始化一个空栈，用于存储柱子的索引。
     * 2、遍历每个柱子，对于每个柱子进行如下处理：
     * 3、如果当前柱子的高度大于栈顶柱子的高度，说明可以形成凹槽，可以接水。
     * 4、弹出栈顶元素，即最低的柱子，并计算当前柱子与栈顶柱子之间的距离以及接水高度，并累加到总的接水量中。
     * 5、重复上述过程直到当前柱子的高度小于等于栈顶柱子的高度，或者栈为空。
     * 6、将当前柱子的索引压入栈中。
     * 7、最终返回总的接水量。
     * 在最坏情况下，每个柱子最多被压入和弹出栈一次，因此时间复杂度为O(n)。
     * 需要额外的空间存储栈，因此空间复杂度为O(n)。
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        Stack<Integer> stack = new Stack<>(); // 用于存储柱子的索引
        int water = 0; // 存储总的接水量

        // 遍历每个柱子
        for (int i = 0; i < n; i++) {
            // 如果当前柱子的高度大于栈顶柱子的高度，说明可以接水
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // 弹出栈顶元素，即最低的柱子
                if (stack.isEmpty()) break; // 如果栈为空，无法继续接水
                int distance = i - stack.peek() - 1; // 计算当前柱子与栈顶柱子之间的距离
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top]; // 计算接水高度
                water += distance * boundedHeight; // 计算接水量并累加
            }
            stack.push(i); // 将当前柱子索引压入栈中
        }

        return water;
    }

    public static void main(String[] args) {
        Solution_42 solution42 = new Solution_42();
        int[] nums1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] nums2 = {4,2,0,3,2,5};
        StopWatch watch = new StopWatch();
        watch.start("trap1 --> nums1");
        int trap1nums1 = solution42.trap1(nums1);
        watch.stop();
        watch.start("trap2 --> nums1");
        int trap2nums1 = solution42.trap2(nums1);
        watch.stop();
        watch.start("trap3 --> nums1");
        int trap3nums1 = solution42.trap3(nums1);
        watch.stop();


        watch.start("trap1 --> nums2");
        int trap1nums2 = solution42.trap1(nums2);
        watch.stop();
        watch.start("trap2 --> nums2");
        int trap2nums2 = solution42.trap2(nums2);
        watch.stop();
        watch.start("trap3 --> nums2");
        int trap3nums2 = solution42.trap3(nums2);
        watch.stop();

        System.out.println(watch.prettyPrint());
        System.out.println(trap1nums1);
        System.out.println(trap2nums1);
        System.out.println(trap3nums1);
        System.out.println(trap1nums2);
        System.out.println(trap2nums2);
        System.out.println(trap3nums2);

        // result :
        // ---------------------------------------------
        //ns         %     Task name
        //---------------------------------------------
        //000009667  004%  trap1 --> nums1
        //000002417  001%  trap2 --> nums1
        //000222666  091%  trap3 --> nums1
        //000001834  001%  trap1 --> nums2
        //000000792  000%  trap2 --> nums2
        //000008584  003%  trap3 --> nums2
        //
        //6
        //6
        //6
        //9
        //9
        //9
    }
}
