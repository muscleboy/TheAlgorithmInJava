package xyz.bugcoder.leetcode_pp.back_track;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
