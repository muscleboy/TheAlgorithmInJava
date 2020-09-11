package xyz.bugcoder.CartoonAlgorithm.chapter_5;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 删除K个数字后的最小值
 * @createTime 2020-09-10 08:16
 */
public class GetMinAfterDelKNums {

    /*
    * @Author: Weiyj
    * @Date: 2020-09-10 08:48
    * @Desc: 位置比数字大小更重要
     * @param nums : 字符串
     * @param k : 删除k个
    * @Returns: java.lang.String
    **/
    public static String getMinAfterDelKNums(String nums, int k){

        if (k > nums.length())
            return "0";

        // 删除k个
        for (int i = 0; i < k; i++) {
            // 找到 比 自己右侧数字大 的数字 并删除
            boolean has = false;
            for (int j = 0; j < nums.length() - 1; j++) {
                // k位置 > 它右边，则删除
                if (nums.charAt(j) > nums.charAt(j + 1)){
                    // substring不包含j位置
                    nums = nums.substring(0, j) + nums.substring(j + 1);
                    // 在高位找到直接break
                    has = true;
                    break;
                }
            }
            // 未找到说明有序，如：12345，直接删除最后一位
            if (!has) {
                nums = nums.substring(0, nums.length() - 1);
            }
        }

        // 去掉前面的0
        int index = 0;
        for (int i = 0; i < nums.length() - 1; i++) {
            if (nums.charAt(index) != '0'){
                break;
            }
            index ++;
        }

        // 截取index到最后一位
        nums = nums.substring(index);
        if (nums.length() == 0)
            return "0";

        return nums;
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-11 08:01
    * @Desc: 优化点：1.每次都要从头开始循环
    *               2.substring性能不高
     * @param nums :
     * @param k :
    * @Returns: java.lang.String
    **/
    public static String getMinAfterDelKNums2(String nums, int k){

        if (k > nums.length())
            return "0";

        int newLength = nums.length() - k;
        char[] stack = new char[nums.length()];
        int top = 0;
        for (int i = 0; i < nums.length(); i++) {
            char c = nums.charAt(i);
            // top-1: i(c)的上一位置
            // top-1 > c，则删除top
            while (top > 0 && stack[top - 1] > c && k > 0){
                top --;
                k --;
            }
            stack[top ++] = c;
        }

        int offset = 0;
        while (stack[offset] == '0')
            offset++;

        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }

    public static void main(String[] args) {
        System.out.println(getMinAfterDelKNums("1593212", 1));
        System.out.println(getMinAfterDelKNums("1234567", 2));
        System.out.println(getMinAfterDelKNums("500056070", 4));
        System.out.println(getMinAfterDelKNums("541270936", 3));
        System.out.println("-----------优化后----------");
        System.out.println(getMinAfterDelKNums2("1593212", 1));
        System.out.println(getMinAfterDelKNums2("1234567", 2));
        System.out.println(getMinAfterDelKNums2("500056070", 4));
        System.out.println(getMinAfterDelKNums2("541270936", 3));
    }

}
