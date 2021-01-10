package xyz.bugcoder.jianzhioffer.back_track;

//输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8
// Related Topics 回溯算法
// 👍 119 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: xyz.bugcoder.jianzhioffer.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-10 12:54
 */
public class Permutation_Mid_38 {

    /**
     * 思路
     *    回溯，s 可能包含重复的元素，要先排序
     * 复杂度
     *    时间：O(N * N!)
     *    时间：O(1)
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 1) {
            return new String[]{s};
        }
        char[] cs = s.toCharArray();
        // 排序是去重的前提
        Arrays.sort(cs);
        boolean[] used = new boolean[cs.length];
        backtrack(res, new StringBuilder(), cs, used, 0);
        return res.toArray(new String[]{});
    }

    public void backtrack(List<String> res, StringBuilder sb, char[] cs, boolean[] used, int depth) {
        if (sb.length() == cs.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < cs.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && cs[i] == cs[i - 1] && !used[i - 1]) {
                continue;
            }
            sb.append(cs[i]);
            used[i] = true;
            backtrack(res, sb, cs, used, depth + 1);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Test
    public void test(){
        String s = "abcd";
        System.out.println(Arrays.toString(permutation(s)));
    }

}
