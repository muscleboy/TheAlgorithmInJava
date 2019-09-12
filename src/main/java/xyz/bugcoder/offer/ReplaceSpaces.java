package xyz.bugcoder.offer;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.offer
 * @Description: 替换空格-05
 * @Date: 2019/9/12 16:39
 * @Author: Wyj
 */
public class ReplaceSpaces {

    /**
    * @Description: 替换空格： "we are happy!" --> we%20are%20happy!
    * @Param: [str] 带空格的字符串
    * @return: void
    */
    public static void replaceSpaces(String str){

        // 将字符串转换成字符数组
        char[] str2char = str.toCharArray();
        // 空格数
        int space = 0;
        // 统计空格数
        for (int i = 0; i < str2char.length; i++) {

            if (str2char[i] == ' ')
                space ++;
        }

        // new一个新的字符数组，长度为str2char.length + space * 2
        char[] newChar = new char[str2char.length + space * 2];
        int i = str2char.length - 1;
        int j = newChar.length - 1;
        // 从后面循环
        while (i >= 0){

            // 遇到空格时
            if (str2char[i] == ' '){

                // 填充02%
                newChar[j] = '0';
                newChar[j - 1] = '2';
                newChar[j - 2] = '%';
                // %20 占3位
                j -= 3;
            }else {

                // 其他位置不变
                newChar[j] = str2char[i];
                // newChar前移
                j --;
            }
            // str2char前移
            i --;
        }

        System.out.println(new String(newChar));
    }

    public static void main(String[] args) {

        replaceSpaces("we are happy!");
    }
}
