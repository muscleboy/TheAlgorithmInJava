package xyz.bugcoder.leetcode_pp.array;

//给你一个由一些多米诺骨牌组成的列表 dominoes。
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且
//b==c。
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。
//
//
//
// 示例：
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= dominoes.length <= 40000
// 1 <= dominoes[i][j] <= 9
//
// Related Topics 数组
// 👍 71 👎 0

/**
 * @author: weiyj
 * @time 2021-01-26 11:12
 * @desc: todo
 */
public class numEquivDominoPairs_ec_1129 {

    public static final int MOD = 10;

    /**
     * 思路
     *    根据题意 [1,2] 等价于 [2,1]，将 较大的数 * mod + 另一个数
     * 复杂度
     *    时间：O(N)
     *    空间：O(1)
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        // 100: 因为(i, j) 的范围为【0, 9】，所以最大值为 99
        int[] nums = new int[100];
        for (int[] d : dominoes) {
            int val = d[0] < d[1] ? d[1] * MOD + d[0] : d[0] * MOD + d[1];
            res += nums[val];
            nums[val]++;
        }
        return res;
    }

}
