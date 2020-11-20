package xyz.bugcoder.leetcode_pp.hash;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
//
// Related Topics 堆 哈希表
// 👍 568 👎 0

import java.util.*;

/**
 * @Package: xyz.bugcoder.leetcode_pp.hash
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-20 08:57
 */
public class TopKFrequent_Mid_347 {

    // 遍历统计出现的次数，得到一个数字、和出现次数的 map，再根据出现次数排序，取出前 K 个，但显然时间复杂度超 NlogN
    public static int[] topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0){
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, ((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }

        return res;
    }

    // 思路
    //   还是使用 Map 统计出现次数，然后改用最小堆
    // 复杂度
    //   时间：统计 O(N)，最小堆为 NlogK
    //   空间：O(N)，最坏需要 N 个存键值对
    public static int[] topKFrequent2(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0){
            return new int[]{};
        }

        // 统计出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 不能排序，而是改用最小堆, logN, 这里用 map.get(o1)出现次数 可以解决负数问题
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> map.get(o1) - map.get(o2)));
        for (Integer key : map.keySet()) {
            if (queue.size() < k){
                queue.offer(key);
            }else {
                if (map.get(queue.peek()) < map.get(key)){
                    // 最小堆是小的优先出去
                    queue.poll();
                    queue.offer(key);
                }
            }
        }

        // top K
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()){
            res[index++] = queue.poll();
        }

        return res;
    }

    // 思路
    //   还是用 map 统计出现频率，然后使用桶排序
    // 复杂度
    //   时间：统计 O(N)，桶排序 O(N)
    //   空间：O(N)
    public static int[] topKFrequent3(int[] nums, int k) {

        // 统计出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 桶下标为该元素出现次数
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (list[freq] == null){
                list[freq] = new ArrayList<>();
            }
            list[freq].add(key);
        }

        List<Integer> res = new ArrayList();
        // top K
        // 出现次数多的越靠后，所以倒序遍历
        for(int i = list.length - 1; i >= 0 && res.size() < k; i--){
            if(list[i] == null)
                continue;
            res.addAll(list[i]);
        }
        // List 转 Array
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,2,2,3,3,3,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
        System.out.println(Arrays.toString(topKFrequent2(nums, 2)));
        System.out.println(Arrays.toString(topKFrequent3(nums, 2)));
    }

}
