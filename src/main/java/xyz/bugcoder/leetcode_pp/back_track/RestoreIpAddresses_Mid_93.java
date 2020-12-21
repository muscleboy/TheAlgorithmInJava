package xyz.bugcoder.leetcode_pp.back_track;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。
//
//
//
// 示例 1：
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
//
//
// 示例 2：
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
//
//
// 示例 3：
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
//
//
// 示例 4：
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
//
//
// 示例 5：
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 3000
// s 仅由数字组成
//
// Related Topics 字符串 回溯算法
// 👍 471 👎 0

/**
 * @Package: xyz.bugcoder.leetcode_pp.back_track
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-21 10:54
 */
public class RestoreIpAddresses_Mid_93 {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12){
            return res;
        }
        List<String> track = new ArrayList<>();
        int splitTimes = 0;
        backtrack(s, track, res, len, splitTimes, 0);
        return res;
    }

    public void backtrack(String s, List<String> track, List<String> res, int len, int splitTimes, int begin){
        // 开始位置 = 长度，意味着结束了
        if(begin == len){
            // IP 地址为 4 部分
            if(splitTimes == 4){
                res.add(String.join(".", track));
            }
            return;
        }
        // 不够、超过  都要剪枝
        if (len - begin < 4 - splitTimes || len - begin > 3 * (4 - splitTimes)){
            return;
        }
        for (int i = 0; i < 3; i++) {
            // 剪枝
            if (begin + i >= len) {
                break;
            }
            Integer ipSeg = isIpSeg(s, begin, begin + i);
            if (ipSeg != -1) {
                track.add(ipSeg + "");
                backtrack(s, track, res, len, splitTimes+1,begin+i+1);
                track.remove(track.size() - 1);
            }
        }
    }

    // 判断字符串 s 的[l, r]是否符合 IP地址
    public Integer isIpSeg(String s, int l, int r){
        int len = r - l + 1;
        // 子串长度>1，且不能是 0 开头
        if(len > 1 && s.charAt(l) == '0'){
            return -1;
        }
        int res = 0;
        for(int i = l; i <= r; i++){
            res = res * 10 + s.charAt(i) - '0';
        }
        if(res > 255){
            return -1;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(restoreIpAddresses("25525511135"));
    }

}
