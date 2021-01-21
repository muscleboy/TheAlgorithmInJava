package xyz.bugcoder.jianzhioffer.string;

//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
// 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
//
//
// Related Topics 数学
// 👍 141 👎 0

/**
 * @author: weiyj
 * @time 2021-01-21 12:46
 * @desc: todo
 */
public class IsNumber_Mid_20 {

    /**
     * 思路
     *    逐个判断
     *    ① .之前不能出现. 或者 e/E
     *    ② e/E 之前不能出现 e/E 或者 没有数字
     *    ③ +- 只能出现在 0 或者 e/E 后面第一个位置
     *    ④ 出现 .+-eE 之外的，都是不可能是数组
     * 复杂度
     *    时间：O(N)
     *    空间：O(N)
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean numUsed = false;
        boolean dotUsed = false;
        boolean eUsed = false;
        char[] cs = s.trim().toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                numUsed = true;
            }
            else if (cs[i] == '.') {
                // .之前不能出现. 或者 e/E
                if (dotUsed || eUsed) {
                    return false;
                }
                dotUsed = true;
            }
            else if (cs[i] == 'e' || cs[i] == 'E') {
                // e/E 之前不能出现 e/E 或者 没有数字
                if (eUsed || !numUsed) {
                    return false;
                }
                eUsed = true;
                // 确保 e/E 之后也出现数字
                numUsed = false;
            }
            else if (cs[i] == '-' || cs[i] == '+') {
                // +- 只能出现在 0 或者 e/E 后面第一个位置
                if (i != 0 && cs[i - 1] != 'e' && cs[i - 1] != 'E') {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return numUsed;
    }

}
