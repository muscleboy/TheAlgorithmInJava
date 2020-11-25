package xyz.bugcoder.jianzhioffer.string;

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
