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

        // 删除k个
        for (int i = 0; i < k; i++) {
            // 找到比自己大的右侧数字并删除
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

    public static void main(String[] args) {
        System.out.println(getMinAfterDelKNums("1593212", 2));
        System.out.println(getMinAfterDelKNums("1234567", 2));
        System.out.println(getMinAfterDelKNums("5000567", 2));
        System.out.println(getMinAfterDelKNums("1000", 1));
    }

}
