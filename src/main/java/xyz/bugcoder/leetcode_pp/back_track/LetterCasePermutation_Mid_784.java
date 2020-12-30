package xyz.bugcoder.leetcode_pp.back_track;

//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
//
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
//
//
//
//
// 提示：
//
//
// S 的长度不超过12。
// S 仅由数字和字母组成。
//
// Related Topics 位运算 回溯算法
// 👍 237 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-30 11:25
 */
public class LetterCasePermutation_Mid_784 {

    // 思路
    //   回溯，每次只有 2 个分支，不需要 for 循环
    // 复杂度
    //   时间：O(N²)
    //   空间：O(N²)
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        char[] cs = s.toCharArray();
        int begin = 0;
        backtrack(res, cs,begin);
        return res;
    }

    // 'A': 65
    // 'a': 97 相差 32，也就是 1 << 5
    // 这里两个分支，所以不需要 for 循环
    public void backtrack(List<String> res, char[] cs, int begin){
        if(begin == cs.length){
            res.add(new String(cs));
            return;
        }
        // 未修改的分支
        backtrack(res, cs, begin + 1);
        // 修改的分支
        if (Character.isLetter(cs[begin])) {
            // 效率更高
//            cs[begin] ^= 1 << 5;
            // 骚操作，异或' ' 可实现大小写转换
            cs[begin] ^= ' ';
            backtrack(res, cs, begin + 1);
        }
    }

    @Test
    public void test(){
        System.out.println(letterCasePermutation("acbe"));
    }

}
