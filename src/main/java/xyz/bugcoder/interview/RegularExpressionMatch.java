package xyz.bugcoder.interview;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.interview
 * @Description: 正则表达式匹配".","*"
 * @Date: 2019-10-15 16:40
 * @Author: Wyj
 */
public class RegularExpressionMatch {

    public static boolean isMatch(String str, String p){

//        char[] cs = str.toCharArray();
//        int one = p.indexOf(".");
//        int all = p.indexOf("*");
//
//        if (cs.length >= one + 1){
//            if (cs[one] == cs[one - 1])
//                return true;
//        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a."));
    }

}
