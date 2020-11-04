package xyz.bugcoder.leetcode_pp.array;

import java.util.LinkedList;

/**
 * @Package: xyz.bugcoder.leetcode_pp.array
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 09:53
 */
public class StringDecoded_Mid_394 {

    // 思路：遍历字符串
    // 1.数字，num入栈
    // 2.字母，append拼接str
    // 3.[，把拼接好的字符串入栈，num, str重置
    // 4.]，num，str出栈，拼接str num次
    // 复杂度：
    // 时间：O(N)，N为字符串的长度
    // 时间：O(N)
    private static String stringDecoded(String str){

        if (str == null || str.isEmpty()){
            return "";
        }

        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // 3[: num表示[前面的数字
        int num = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 数字
            if (c >= '0' && c <= '9'){
                // *10: 可能为12[ab]，num初始为0，<10也没关系，也能正常
                num = num * 10 + c - '0';
            }
            // 字母
            else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                sb.append(c);
            }
            // [
            else if (c == '['){
                if (num > 0){
                    numStack.push(num);
                }
                // 入栈，重置
                strStack.push(sb.toString());
                sb = new StringBuilder();
                num = 0;
            }
            // ]
            else {
                StringBuilder temp = new StringBuilder().append(strStack.pop());
                // 重复的次数
                int t = numStack.pop();
                for (int j = 0; j < t; j++) {
                    temp.append(sb);
                }
                sb = temp;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // [ab]，当出现1次时，省略1会出错
        String s = "2[abc]3[gc]1[my]";
        System.out.println(stringDecoded(s));
    }

}
