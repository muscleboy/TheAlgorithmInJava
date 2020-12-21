package xyz.bugcoder.leetcode_pp.back_track;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1046 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-21 12:24
 */
public class LetterCombinations_Mid_17 {

    public List<String> letterCombinations(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        StringBuilder track = new StringBuilder();
        int begin = 0;
        backtrack(map, res, track, s, begin);
        return res;
    }

    // 回溯
    public void backtrack(HashMap<Integer, String> map, List<String> res, StringBuilder track, String s, int begin){
        // 终止条件
        if (track.length() == s.length()) {
            res.add(track.toString());
            return;
        }
        int key = s.charAt(begin) - '0';
        String val = map.get(key);

        for (int i = 0; i < val.length(); i++) {
            track.append(val.charAt(i));
            backtrack(map, res, track, s, begin+1);
            track.deleteCharAt(track.length() - 1);
        }
    }

    @Test
    public void  test(){
        System.out.println(letterCombinations("23"));
    }

}
