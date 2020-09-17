package xyz.bugcoder.CartoonAlgorithm.chapter_5;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: 获取最大金矿(dp)
 * @createTime 2020-09-16 08:00
 */
public class GetBestGoldMining {

    /*
    * @Author: Weiyj
    * @Date: 2020-09-16 08:02
    * @Desc: 递归法 O(2^n)
     * @param w : 工人
     * @param n : 金矿数量
     * @param p : 金矿开采所需人数
     * @param g : 金矿含金量
    * @Returns: int
    **/
    public static int getBestGoldMining(int w, int n, int[] p, int[] g){

        if (w == 0 || n == 0)
            return 0;

        if (w < p[n - 1])
            return getBestGoldMining(w, n-1, p , g);

        int a = getBestGoldMining(w, n-1, p, g);
        int b = getBestGoldMining(w-p[n-1], n-1, p, g) + g[n-1];
        System.out.println("a: " + a + ", b:" + b);
        return Math.max(a, b);

    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-17 07:23
    * @Desc: O(nw), 动态规划自底向上解法
     * @param w : 工人数
     * @param p : 开发金矿需要的人数
     * @param g : 金矿含金量
    * @Returns: int
    **/
    public static int getBestGoldMining2(int w, int[] p, int[] g){
        int[][] resultTable = new int[g.length + 1][w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i-1]){
                    resultTable[i][j] = resultTable[i-1][j];
                }
                else{
                    resultTable[i][j] = Math.max(resultTable[i-1][j], resultTable[i-1][j-p[i-1]] + g[i-1]);
                }
            }
        }

        return resultTable[g.length][w];
    }

    /*
    * @Author: Weiyj
    * @Date: 2020-09-17 07:48
     * @Desc: O(n)
     * @param w : 工人数
     * @param p : 开发金矿需要的人数
     * @param g : 金矿含金量
     * @Returns: int
    **/
    public static int getBestGoldMining3(int w, int[] p, int[] g){
        int[] result = new int[w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j >= p[i-1]){
                    result[j] = Math.max(result[j], result[j-p[i-1]] + g[i-1]);
                }
            }
        }

        return result[w];
    }

    public static void main(String[] args) {
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
//        System.out.println(getBestGoldMining(w, g.length, p, g));
        System.out.println(getBestGoldMining2(w, p, g));
        System.out.println(getBestGoldMining3(w, p, g));
    }

}
