package xyz.bugcoder.leetcode_pp.hash;

//给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺
//序）。
//
// 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
//
// 示例:
//
//
//输入:
//[[0,0],[1,0],[2,0]]
//
//输出:
//2
//
//解释:
//两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
//
// Related Topics 哈希表 数学
// 👍 117 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-21 09:41
 */
public class NumberOfBoomerangs_Mid_447 {

    // 思路
    //   暴力枚举，双层循环，固定一端，计算左端到右端的距离，map<距离，次数> 统计
    // 复杂度
    //   时间：双层循环 O(N²)
    //   空间：Map最多需要存 N 个键值对
    public static int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            // <距离, 次数>
            Map<Integer, Integer> disMap = new HashMap<>();
            // 都是从0 开始，意味着
            for (int j = 0; j < points.length; j++) {
                if (j != i){
                    int dis = dis(points[i], points[j]);
                    disMap.put(dis, disMap.getOrDefault(dis, 0) + 1);
                }
            }
            // 从 n 个中选出 2 个，有 Cn²中排列组合，= n * (n-1)
            for (int freq : disMap.values()) {
                // 能减少些计算
                if (freq >= 2)
                    res += freq * (freq - 1);
            }
        }

        return res;
    }

    public static int dis(int[] a, int[] b){
        return (a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1])*(a[1] - b[1]);
    }

    public static void main(String[] args) {
        int[][] a = {{1,0},{0,0},{2,0}};
        System.out.println(numberOfBoomerangs(a));
    }

}
