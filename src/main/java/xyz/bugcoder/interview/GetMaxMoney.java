package xyz.bugcoder.interview;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.interview
 * @Description:
 * @Date: 2019-10-25 17:05
 * @Author: Wyj
 */
public class GetMaxMoney {

    public static void main(String[] args) {
        int[] arr = {100,1,1,100,1,1,100};
        getMaxMoney(arr);
    }

    private static void getMaxMoney(int[] arr) {

        int max = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+2; j < arr.length; j++) {
                if (arr[i] + arr[j] > max)
                    max = arr[i] + arr[j];
            }
        }

        System.out.println(max);
    }

}
