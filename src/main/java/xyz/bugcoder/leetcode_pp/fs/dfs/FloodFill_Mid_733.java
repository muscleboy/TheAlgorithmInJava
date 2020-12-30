package xyz.bugcoder.leetcode_pp.fs.dfs;

//有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
//
// 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
//
// 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方
//向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
//
// 最后返回经过上色渲染后的图像。
//
// 示例 1:
//
//
//输入:
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析:
//在图像的正中间，(坐标(sr,sc)=(1,1)),
//在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，
//因为它不是在上下左右四个方向上与初始点相连的像素点。
//
//
// 注意:
//
//
// image 和 image[0] 的长度在范围 [1, 50] 内。
// 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
// image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
//
// Related Topics 深度优先搜索
// 👍 154 👎 0

import org.junit.Test;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.leetcode_pp.fs.dfs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-30 10:39
 */
public class FloodFill_Mid_733 {

    // 思路
    //   看懂题目！！！，从 [row][col] 开始，把 与之相连 && 颜色值为 image[row][col] 修改为 newColor
    // 复杂度
    //   时间：O(m*n)
    //   空间：O(1)
    public int[][] floodFill(int[][] image, int row, int col, int newColor) {
        int oldColor = image[row][col];
        if(oldColor != newColor){
            dfs(image, row, col, oldColor, newColor);
        }
        return image;
    }
    // oc: oldColor
    // nc: newColor
    public void dfs(int[][] image, int i, int j, int oc, int nc){
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length){
            return;
        }
        // 是旧颜色，就将其 上下左右 上新颜色
        if(image[i][j] == oc){
            image[i][j] = nc;
            dfs(image, i, j+1, oc, nc);
            dfs(image, i, j-1, oc, nc);
            dfs(image, i+1, j, oc, nc);
            dfs(image, i-1, j, oc, nc);
        }
    }

    @Test
    public void test(){
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 3)));
    }

}
