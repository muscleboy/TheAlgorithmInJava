package xyz.bugcoder.jianzhioffer.string;

//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。
//
//
//
// 示例 1：
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
//
//
// 示例 2：
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//
//
// 示例 3：
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//
//
// 说明：
//
//
// 无空格字符构成一个单词。
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
//
//
// 注意：此题对比原题有改动
// Related Topics 字符串
// 👍 50 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.string
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-25 16:33
 */
public class ReverseWords_58_I {

    // 思路
    //   trim 去掉收尾空格，split 按" "切割，倒序遍历，面试的时候...
    // 复杂度
    //   时间：O(N)
    //   空间：O(N)
    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals(" "))
                continue;
            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();
    }

    // 思路
    //   尾尾双指针，倒序遍历，遇到空格跳过
    // 复杂度
    //   时间：O(N)，s 的长度
    //   空间：O(N), StringBuilder
    public static String reverseWords2(String s) {

        StringBuilder sb = new StringBuilder();
        // 去掉收尾空格
        s = s.trim();
        int i = s.length() - 1;
        int j = s.length() - 1;
        while (i >= 0){
            while (i >= 0 && s.charAt(i) != ' '){
                i --;
            }
            // "hello".substring(1,3)   el
            String word = s.substring(i+1, j+1);
            sb.append(word).append(" ");
            while (i >= 0 && s.charAt(i) == ' '){
                i --;
            }
            j = i;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
        System.out.println("hello".substring(1,3));
    }

}
