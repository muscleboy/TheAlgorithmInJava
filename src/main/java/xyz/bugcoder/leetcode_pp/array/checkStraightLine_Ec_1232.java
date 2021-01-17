package xyz.bugcoder.leetcode_pp.array;

//在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为
// x、纵坐标为 y 的点。
//
// 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
//
//
//
// 示例 1：
//
//
//
// 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
//
//
// 示例 2：
//
//
//
// 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
//
//
//
//
// 提示：
//
//
// 2 <= coordinates.length <= 1000
// coordinates[i].length == 2
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
// coordinates 中不含重复的点
//
// Related Topics 几何 数组 数学
// 👍 76 👎 0

/**
 * @author: weiyj
 * @time 2021-01-17 23:35
 * @desc: todo
 */
public class checkStraightLine_Ec_1232 {

    /**
     * 思路
     *    比较三点斜率，(y2 - y1)/(x2 - x1) == (y3 - y2)/(x3 - x2)
     *    因为除法比较麻烦，所有改成乘法，交叉相乘
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param nums
     * @return
     */
    public boolean checkStraightLine(int[][] nums) {
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            int dx = nums[i][0] - nums[i - 1][0];
            int dy = nums[i][1] - nums[i - 1][1];

            int dx2 = nums[i + 1][0] - nums[i][0];
            int dy2 = nums[i + 1][1] - nums[i][1];
            // * 1.0 防止超范围
            if (1.0 * dx * dy2 != 1.0 * dy * dx2) {
                return false;
            }
        }
        return true;
    }

}
