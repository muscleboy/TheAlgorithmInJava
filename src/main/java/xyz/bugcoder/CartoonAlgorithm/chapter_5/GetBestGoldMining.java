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

    public static void main(String[] args) {
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        System.out.println(getBestGoldMining(w, g.length, p, g));
    }

}
