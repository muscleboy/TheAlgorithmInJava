package xyz.bugcoder.leetcode_pp.weekly.w_220;

import org.junit.Test;

// 5629. 重新格式化电话号码
//给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
//
//请你按下述方式重新格式化电话号码。
//
//首先，删除 所有的空格和破折号。
//其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
//2 个数字：单个含 2 个数字的块。
//3 个数字：单个含 3 个数字的块。
//4 个数字：两个分别含 2 个数字的块。
//最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
//
//返回格式化后的电话号码。

/**
 * @Package: xyz.bugcoder.leetcode_pp
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 18:00
 */
public class reformatNumber {

    public String reformatNumber(String s) {
        // 去掉空格、'-'
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != ' ' && c != '-')
                sb.append(c);
        }
        int n = 0;
        StringBuilder res = new StringBuilder();
        // 全部按 xxx-xxx 处理，包括剩下 2、3 位的情况
        for(int i = 0; i < sb.length(); i ++){
            if(n == 3){
                res.append('-');
                n = 0;
            }
            n ++;
            res.append(sb.charAt(i));
        }

        // 输入s：123 4-567
        // 处理到这里res：123-456-7
        if(sb.length() % 3 == 1){
            StringBuilder temp = new StringBuilder();
            temp.append('-').append(sb.substring(sb.length() - 2));
            String t = res.substring(0, res.length() - 3);
            return t + temp;
        }
        return res.toString();
    }

    @Test
    public void test(){
        String s = "123-456-7";
        System.out.println(s.substring(0, s.length() - 3));
        System.out.println(reformatNumber(s));
    }

}
