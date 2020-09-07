package xyz.bugcoder.CartoonAlgorithm.chapter_5;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 有一个无序数组，如何求出该数组排序后的任意两个相邻元素的最大差值？
 * @createTime 2020-09-04 07:49
 */
public class GetMaxDistance {

    private static class Bucket {
        Integer max;
        Integer min;
    }

    public static int getMaxDistance(int[] arr){

        if (arr == null || arr.length == 0)
            return 0;

        // 1.先找出数组中的最大、最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        int d = max - min;
        if (d == 0)
            return 0;

        // 2.初始化捅
        int bucketNum = arr.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        // 3.遍历原数组，确定每个桶的最大、最小值
        for (int i = 0; i < arr.length; i++) {
            // 确定数组元素所属的捅下标
            // index: 0 3 0 1 2 6 5
            int index = ((arr[i] - min) * (bucketNum - 1)/d);
            if (buckets[index].min == null || buckets[index].min > arr[i])
                buckets[index].min = arr[i];
            if (buckets[index].max == null || buckets[index].max > arr[i])
                buckets[index].max = arr[i];
        }

        // 4.遍历捅，找出最大差值
        // leftMax: 左边捅(上一个)的最大值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null)
                continue;
            if (buckets[i].min - leftMax > maxDistance)
                maxDistance = buckets[i].min - leftMax;
            leftMax = buckets[i].max;
        }

        return maxDistance;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{4,4,7,1,2,3,6,8,9};
        int[] arr = new int[]{2,6,3,4,5,10,9};
        System.out.println(getMaxDistance(arr));
    }

}
