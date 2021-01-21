package xyz.bugcoder.jianzhioffer.array;

//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
//
//
// 示例 1:
//
// 输入: [10,2]
//输出: "102"
//
// 示例 2:
//
// 输入: [3,30,34,5,9]
//输出: "3033459"
//
//
//
// 提示:
//
//
// 0 < nums.length <= 100
//
//
// 说明:
//
//
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
//
// Related Topics 排序
// 👍 142 👎 0

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author: weiyj
 * @time 2021-01-21 11:02
 * @desc: todo
 */
public class minNumber_Mid_45 {

    /**
     * 思路
     *    自定义选择器，x = 3，y = 50，
     *    350 < 503
     * 复杂度
     *    时间：O(NlogN)
     *    空间：O(N)
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // x = 3，y = 50 350 < 503
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }

    /**
     * 思路
     *    压缩代码，实际不要这么写！！！
     * @param nums
     * @return
     */
    public String minNumber2(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((x, y) -> (x + y).compareTo(y + x))
                .collect(Collectors.joining());
    }

    @Test
    public void test(){
        int[] nums = {3, 29, 34, 5, 9};
        System.out.println(minNumber(nums));
        System.out.println(minNumber2(nums));
    }

}
