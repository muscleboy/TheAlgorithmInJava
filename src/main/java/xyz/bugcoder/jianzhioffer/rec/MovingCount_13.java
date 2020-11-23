package xyz.bugcoder.jianzhioffer.rec;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//
//
// 示例 1：
//
// 输入：m = 2, n = 3, k = 1
//输出：3
//
//
// 示例 2：
//
// 输入：m = 3, n = 1, k = 0
//输出：1
//
//
// 提示：
//
//
// 1 <= n,m <= 100
// 0 <= k <= 20
//
// 👍 179 👎 0

/**
 * @Package: xyz.bugcoder.jianzhioffer.rec
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-23 15:46
 */
public class MovingCount_13 {

    // 思路
    //   dfs，每遍历一个点就检测其上下左右是否满足，满足 + 1， 否则跳过
    // 复杂度
    //   时间：需要遍历 m*n 次
    //   空间：需要 m*n 的空间
    public int movingCount(int m, int n, int k) {

        if (k == 0){
            return 1;
        }

        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    // i,j 要为 0~m 0~n 的距离
    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited){
        if (i < 0 || i >= m || j < 0 || j >= n || sum(i) + sum(j) > k || !visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        // visited[i][j] 位置上下左右
        return 1 + dfs(i + 1, j, m, n, k, visited)
                + dfs(i, j + 1, m, n, k, visited)
                + dfs(i - 1, j, m, n, k, visited)
                + dfs(i, j - 1, m, n, k, visited);
    }

    // 求一个数的数位之和，如 sum(15) = 1 + 5 = 6;
    public static int sum(int num){

        if (num < 10){
            return num;
        }

        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(15));
    }

}
