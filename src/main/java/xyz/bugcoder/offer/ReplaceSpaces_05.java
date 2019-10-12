package xyz.bugcoder.offer;
/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.offer
 * @Description: 替换空格-05
 * @Date: 2019/9/12 16:39
 * @Author: Wyj
 */
public class ReplaceSpaces_05 {

    /**
    * @Description: 替换空格： "we are happy!" --> we%20are%20happy!
    * @Param: [str] 带空格的字符串
    * @return: void
    */
    public static void replaceSpaces(String str){

        // 字符串转化成空格
        char[] str2char = str.toCharArray();
        // 空格数
        int spaces = 0;
        for (char c : str2char) {
            if (c == ' ')
                spaces ++;
        }

        // 新数组的长度：原数组.length + spaces*2
        char[] result = new char[str2char.length + spaces*2];
        // 新旧数组的下边 i, j
        int i = str2char.length - 1;
        int j = result.length - 1;
        // 新数组从后往前遍历
        while (j >= 0){

            // 没遇到空格，照常复制
            result[j] = str2char[i];
            // 遇到空格，j='0'，j-1='2',j-2='%'
            if (str2char[i] == ' '){

                result[j] = '0';
                result[j - 1] = '2';
                result[j- 2] = '%';
                // -2是多出的d2位
                j -= 2;
            }
            // 依次向前
            j --;
            i --;
        }

        System.out.println(new String(result));
    }

    public static void main(String[] args) {

        replaceSpaces("we are happy!");
    }
}
