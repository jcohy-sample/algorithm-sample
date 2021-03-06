package com.jcohy.sample.algorithm.stack;

import java.util.Stack;

// tag::code[]
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    /**
     * 数据压入规则
     * 当前数据为 newNum,先将其压入 stackData，然后判断 stackMin 是否为空
     * 如果为空，则 newNum 也压入 stackMin.
     * 如果不为空，则比较 newNum 和 stackMin 的栈顶元素哪一个更小
     * 如果 newNum 小于等于。则 newNum 也压入 stackMin
     * 如果 stackMin 中栈顶元素小，则 stackMin 中不压入任何元素
     */
    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.stackMin.peek()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    /**
     * 数据弹出规则
     * 先在stackData中弹出栈顶元素，记为value，然后比较当前stackMin的栈顶元素和value哪一个更小
     * 由压入规则我们能知道，不会出现value比stackMin栈顶元素更小的情况，只能大于或者等于
     * 当value等于stackMin的栈顶元素，stackMin弹出栈顶元素
     * 当value大于stackMin的栈顶元素，stackMin不弹出栈顶元素
     */
    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your Stack Is Empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your Stack Is Empty");
        }

        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 ms = new MyStack1();
        ms.push(2);
        ms.push(1);
        ms.push(8);
        ms.push(3);
        System.out.println(ms.stackData.toString());
        System.out.println(ms.stackMin.toString());
        System.out.println(ms.getMin());
    }
}
// end::code[]