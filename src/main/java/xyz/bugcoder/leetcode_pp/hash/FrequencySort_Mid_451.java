package xyz.bugcoder.leetcode_pp.hash;

//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//
// 示例 1:
//
//
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//
//
// 示例 2:
//
//
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//
//
// 示例 3:
//
//
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
//
// Related Topics 堆 哈希表
// 👍 197 👎 0

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-27 11:18
 */
public class FrequencySort_Mid_451 {

    // 思路
    //   首先统计各个字符出现频率，再优先队列
    // 复杂度
    //   时间：O(nlogn)
    //   空间：O(n)
    public String frequencySort(String s) {
        if (s.length() < 2) {
            return s;
        }
        // 统计各个字符出现的次数
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        // 优先队列
        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> freq[b] - freq[a]);
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                heap.offer((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (freq[c]-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(frequencySort("tree"));
    }

}
