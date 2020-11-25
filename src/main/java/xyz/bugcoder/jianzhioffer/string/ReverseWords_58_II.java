package xyz.bugcoder.jianzhioffer.string;

//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。
//
//
//
// 示例 1：
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
//
//
// 示例 2：
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
//
//
//
//
// 限制：
//
//
// 1 <= k < s.length <= 10000
//
// Related Topics 字符串
// 👍 67 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.string
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-25 16:33
 */
public class ReverseWords_58_II {

    // 思路
    //   substring 有点耍流氓了...
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static String reverseLeftWords(String s, int n) {

        return s.substring(n) + s.substring(0, n);
    }

    public static String reverseLeftWords2(String s, int n) {

        StringBuilder sb = new StringBuilder();
//        for (int i = n; i < s.length(); i++) {
//            sb.append(s.charAt(i));
//        }
//        for (int i = 0; i < n; i++) {
//            sb.append(s.charAt(i));
//        }

        // 简化上面的代码  求余
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }

        return sb.toString();
    }

    public static String reverseLeftWords3(String s, int n) {

        String res = "";
        for (int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s,  3));
        System.out.println(reverseLeftWords2(s,  3));
        System.out.println(reverseLeftWords3(s,  3));
    }

}
