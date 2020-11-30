package xyz.bugcoder.leetcode_pp.sliding_window;

//珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
//
// 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//
// 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
//
//
//
//
//
//
// 示例 1：
//
// 输入: piles = [3,6,7,11], H = 8
//输出: 4
//
//
// 示例 2：
//
// 输入: piles = [30,11,23,4,20], H = 5
//输出: 30
//
//
// 示例 3：
//
// 输入: piles = [30,11,23,4,20], H = 6
//输出: 23
//
//
//
//
// 提示：
//
//
// 1 <= piles.length <= 10^4
// piles.length <= H <= 10^9
// 1 <= piles[i] <= 10^9
//
// Related Topics 二分查找
// 👍 121 👎 0


/**
 * @Package: xyz.bugcoder.leetcode_pp.double_pointer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 14:50
 */
public class MinEatSpeed_Mid_875 {

    // 思路
    //   看懂题目！！！！，题目是求满足条件的最小速度，所以是对速度进行二分
    // 复杂度
    //   时间：找最大值O(N)，寻找合适的速度 logL，L 为数组的长度，其中需要进行一次求 sumHour O(N)，所以总的是 O(NlogL)
    //   空间：O(1)
    public int minEatingSpeed(int[] piles, int H) {

        // 吃香蕉的最大速度
        int maxVal = 1;
        for (int p : piles) {
            maxVal = Math.max(maxVal, p);
        }
        int l = 1;
        int r = maxVal;
        while (l < r){
            int mid = (l + r)/2;
            // 吃的太慢了超时，要被抓了，所以要吃的快点，也就是[mid+1, r]
            if (calSumHour(piles, mid) > H){
                l = mid + 1;
            }else {
                // 吃的快了，要慢点，因为是吃完所有香蕉的最小速度
                r = mid;
            }
        }

        return l;
    }

    // 以每小时 speed/H 的速度吃掉这么多堆piles香蕉🍌，耗费的总时间
    public int calSumHour(int[] piles, int speed){
        int sum = 0;
        for (int p : piles) {
            sum += (p + (speed - 1))/speed;
        }

        return sum;
    }

}
