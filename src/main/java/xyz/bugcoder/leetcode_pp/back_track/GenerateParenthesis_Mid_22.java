package xyz.bugcoder.leetcode_pp.back_track;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1490 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-28 12:23
 */
public class GenerateParenthesis_Mid_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        backtrack(res, path, n, n);
        return res;
    }

    /**
     * @param res : 结果
     * @param path : 路径
     * @param left : 还剩多少个"("
     * @param right : 还剩多少个")"
    **/
    public void backtrack(List<String> res, StringBuilder path, int left, int right){
        // 终止条件
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            path.append("(");
            // 选择
            backtrack(res, path, left - 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right > 0) {
            path.append(")");
            backtrack(res, path, left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }

}
