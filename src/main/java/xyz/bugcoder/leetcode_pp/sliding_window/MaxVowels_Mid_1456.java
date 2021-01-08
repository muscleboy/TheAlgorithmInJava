package xyz.bugcoder.leetcode_pp.sliding_window;

//给你字符串 s 和整数 k 。
//
// 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
//
// 英文中的 元音字母 为（a, e, i, o, u）。
//
//
//
// 示例 1：
//
// 输入：s = "abciiidef", k = 3
//输出：3
//解释：子字符串 "iii" 包含 3 个元音字母。
//
//
// 示例 2：
//
// 输入：s = "aeiou", k = 2
//输出：2
//解释：任意长度为 2 的子字符串都包含 2 个元音字母。
//
//
// 示例 3：
//
// 输入：s = "leetcode", k = 3
//输出：2
//解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
//
//
// 示例 4：
//
// 输入：s = "rhythms", k = 4
//输出：0
//解释：字符串 s 中不含任何元音字母。
//
//
// 示例 5：
//
// 输入：s = "tryhard", k = 4
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10^5
// s 由小写英文字母组成
// 1 <= k <= s.length
//
// Related Topics 字符串 Sliding Window
// 👍 10 👎 0

import org.junit.Test;

/**
 * @Package: xyz.bugcoder.leetcode_pp.sliding_window
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-08 11:56
 */
public class MaxVowels_Mid_1456 {

    /**
     * 思路：
     *    固定窗口大小为 k，先循环 k 步，统计元音的个数，此时形成 k 大小的窗口，
     *    再从 k 开始遍历，右窗口是元音 count++, 左窗口是元音 count--
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {

        int count = 0;
        // 长度为 k 的窗口
        for (int i = 0; i < k; i++) {
            // 全是元音
            if (i >= s.length()) {
                return count;
            }
            count += isVowel(s.charAt(i));
        }

        int max = count;
        for (int i = k; i < s.length(); i ++) {
            // 重复计数，所以要减掉左窗口
            count += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            max = Math.max(max, count);
        }
        return max;
    }

    public int isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }

    /**
     * 思路：
     *    固定窗口大小为 k，先循环 k 步，统计元音的个数，此时形成 k 大小的窗口，
     *    再从 k 开始遍历，右窗口是元音 count++, 左窗口是元音 count--
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param s
     * @param k
     * @return
     */
    public int maxVowels2(String s, int k) {
        int max = 0;
        int count = 0;
        int n = s.length();

        // 元音字符串
        String vowel = "aeiou";
        for(int l = 0, r = 0; r < n; r ++){
            if(vowel.indexOf(s.charAt(r)) != -1){
                count ++;
            }
            // 窗口大小为 k
            if(r >= k){
                if(vowel.indexOf(s.charAt(l)) != -1){
                    // --：还未形成窗口大小为 k 的时候，已经统计了一些 元音
                    // 所以后面要形成窗口后，要--
                    count --;
                }
                l ++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    @Test
    public void test(){
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
        System.out.println(maxVowels2(s, k));
    }

}
