package xyz.bugcoder.leetcode_pp.back_track;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 456 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 12:25
 */
public class Combine_Mid_77 {

    List<List<Integer>> res = new ArrayList<>();

    // 思路
    //   回溯，记录开始 begin 位置，下次回溯从 begin+1 开始
    // 复杂度
    //   时间：O(Cnk) ?
    //   空间：O(Cnk) ?
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();
        // 1~n，所以这里的 begin 是从 1 开始
        backtrack(track, n, k, 1);
        return res;
    }

    public void backtrack(List<Integer> track, int n, int k, int begin){
        // 终止条件
        if(track.size() == k){
            res.add(new ArrayList<>(track));
            return;
        }
        // k - track.size(): 已经选了 track.size() 个，还差 k - track.size()
        // 起点 + 接下来要选的个数 - 1 = n
        for(int i = begin; i <= n - (k - track.size()) + 1; i ++){
            // 这个不需要，因为下一个从 i + 1开始
            // 另外 contains 很耗时
//            if(track.contains(n)){
//                continue;
//            }
            track.add(i);
            // 如果回溯不是从 i+1 开始的话，会出现[1,1], [2,2]
            backtrack(track, n, k, i + 1);
            track.remove(track.size() - 1);
        }
    }

    @Test
    public void test(){
        Combine_Mid_77 c = new Combine_Mid_77();
        System.out.println(c.combine(4, 2));
    }

}
