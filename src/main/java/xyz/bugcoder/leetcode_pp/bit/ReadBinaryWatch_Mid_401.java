package xyz.bugcoder.leetcode_pp.bit;

//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。
//
//
//
// 例如，上面的二进制手表读取 “3:25”。
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
//
//
//
// 示例：
//
// 输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"]
//
//
//
// 提示：
//
//
// 输出的顺序没有要求。
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
//
// Related Topics 位运算 回溯算法
// 👍 212 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.leetcode_pp.bit
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2021-01-13 21:26
 */
public class ReadBinaryWatch_Mid_401 {

    /**
     * 思路
     *    乍一看简单题，还无从下手....
     *    后面发现其实就是 小时位置 1 出现的次数为 a，分钟为 b，且 a + b = n
     *    所以 2 个循环(小时，分钟)
     * 复杂度
     *    时间：O(1)，n 最大为 10，最多需要循环 12 * 60 * 10 次，应该算是常数阶
     *    空间：O(1)
     * @param n
     * @return
     */
    public List<String> readBinaryWatch(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int bitCount = getBitCount(i) + getBitCount(j);
                // 还可以用 Integer.bitCount(i)
                StringBuilder sb = new StringBuilder();
                if (bitCount == n) {
                    sb.append(i).append(":");
                    // 当分钟 < 10 的时候，要在前面加个 0
                    if (j < 10) {
                        sb.append(0);
                    }
                    sb.append(j);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

    /**
     * 计算 n 的二进制 1 的个数
     * @param n
     * @return
     */
    public int getBitCount(int n) {
        int bitCount = 0;
        while (n != 0) {
            n &= n - 1;
            bitCount ++;
        }
        return bitCount;
    }

}
