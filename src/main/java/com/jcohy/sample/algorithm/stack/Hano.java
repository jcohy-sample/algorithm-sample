package com.jcohy.sample.algorithm.stack;
// tag::code[]
/**
 * 汉诺塔问题，
 * 这里修改规则，现在限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧到最左测
 * 而是必须经过中间。求当有 N 层塔时，打印最优移动过程和最优移动总步数
 * 递归的方法，只剩上层塔是有六种移动方法(左中，中左，左右，右左，中右，右中)即递归的终止条件
 * <p>
 * 思想:
 * 1.如果只剩 N 层，从最上到最下为 1~N 都在左，希望全部到中，有 3 步。
 * 1.)将 1~N-1 层先全部从左到右。
 * 2.)将第 N 层从左到右。
 * 3.)将 1~N-1 从右到左。
 * 2.如果把剩下的 N 层塔从中到左，中到右，右到中。和上面的同理。
 * 3.如果把剩下的 N 层塔都在左，希望到右。有5步。
 * 1.)将 1~N-1 层先全部从左到右。
 * 2.)将 N 层塔从左到中。
 * 3.)将 1~N-1 层从右到左。
 * 4.)将 N 从中到右。
 * 5.)将 1~N-1 层从左到右。
 * 4.如果把剩下的 N 层塔都在右，希望到左。同理。
 *
 * @author jcohy
 */
public class Hano {
    public static int hanoi(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public static int process(int num, String left, String mid, String right,
                              String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("将 1 从" + from + " 移到" + to);
                return 1;
            } else {
                System.out.println("将 1 从 " + from + " 移到 " + mid);
                System.out.println("将 1 从 " + mid + " 移到 " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(mid) || to.equals(mid)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("将 " + num + " 从 " + from + " 移到 " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("将 " + num + " 从 " + mid + " 移到 " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int result = hanoi(11, "左", "中", "右");
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("一共用了 " + result + "步，花费了" + time + "毫秒");
    }
}
// end::code[]