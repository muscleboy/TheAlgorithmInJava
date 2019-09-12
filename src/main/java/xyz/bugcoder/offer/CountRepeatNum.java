package xyz.bugcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.offer
 * @Description: 统计数组中重复数字
 * @Date: 2019/9/12 17:29
 * @Author: Wyj
 */
public class CountRepeatNum {

    public static void countRepeatNum(int[] nums){

        // 将重复的数据添加到List中
        List<Integer> repeatedNum = new ArrayList<>();
        // 比较的轮次
        for (int j = 0; j < nums.length - 1; j++) {
            //
            for (int i = j; i < nums.length - 1; i++) {
                // 每一位与下一位比较，相等就添加到 List中
                if (nums[j] == nums[i + 1])
                    repeatedNum.add(nums[j]);
            }
        }

        for (Integer i : repeatedNum) {

            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] test = new int[]{2, 3, 1, 0, 2, 5, 3, 4, 6, 65, 76, 65};
        countRepeatNum(test);
    }
}
