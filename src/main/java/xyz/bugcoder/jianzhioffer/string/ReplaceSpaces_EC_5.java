package xyz.bugcoder.jianzhioffer.string;

/**
 * @Package: xyz.bugcoder.jianzhioffer.string
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-22 13:13
 */
public class ReplaceSpaces_EC_5 {

    // 思路
    //   直接用StringBuilder，但有点耍流氓了...
    // 复杂度
    //   时间：O(N)
    //   空间：O(1)
    public static String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();

        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    // 思路
    //   字符串s转字符数组，统计空格数，后往前遍历，遇到' '，j -= 2
    public static String replaceSpace2(String s) {

        char[] cs = s.toCharArray();
        int spaces = 0;
        for (char c : cs) {
            if (c == ' '){
                spaces ++;
            }
        }
        char[] res = new char[cs.length + spaces * 2];

        // 因为是数组，所以 i，j 的值是从0 ~ length-1；
        int i = cs.length - 1;
        int j = res.length - 1;
        while (j >= 0 && i >= 0) {
            if (cs[i] == ' '){
                res[j] = '0';
                res[j - 1] = '2';
                res[j - 2] = '%';
                j -= 2;
            }else {
                res[j] = cs[i];
            }
            j --;
            i --;
        }

        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
        System.out.println(replaceSpace2("We are happy."));
    }

}
