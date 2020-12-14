package xyz.bugcoder.leetcode_pp.hash;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 578 👎 0

import java.util.*;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-14 15:31
 */
public class GroupAngrams_Mid_49 {

    // 思路
    //   字母异位词：也就是字母都一样，只是位置不一样，可以对其进行排序，就能得到相同的 key
    //   然后题目就跟常规的统计次数一样了
    // 复杂度
    //   时间：O(N * mlogm), N 为字符串数组长度，Arrays.sort 为 mlogm
    //   空间：O(N)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 转成字符数组
            char[] cs = s.toCharArray();
            // 排序
            Arrays.sort(cs);
            String key = new String(cs);
            List<String> list = map.get(key);
            list = list == null ? new ArrayList<>() : list;
            list.add(s);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
    }

}
