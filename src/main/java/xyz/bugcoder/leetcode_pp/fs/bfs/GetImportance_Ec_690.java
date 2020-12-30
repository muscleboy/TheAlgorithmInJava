package xyz.bugcoder.leetcode_pp.fs.bfs;

//给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
//
// 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是
//[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
//
//
// 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
//
// 示例 1:
//
//
//输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//输出: 11
//解释:
//员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
//
//
// 注意:
//
//
// 一个员工最多有一个直系领导，但是可以有多个直系下属
// 员工数量不超过2000。
//
// Related Topics 深度优先搜索 广度优先搜索 哈希表
// 👍 122 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

import java.util.*;

/**
 * @Package: xyz.bugcoder.leetcode_pp.fs.bfs
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-25 11:50
 */
public class GetImportance_Ec_690 {

    // 思路
    //   BFS
    // 复杂度
    //   时间： O(N)
    //   空间： O(N)
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        employees.forEach(item -> map.put(item.id, item));
        Employee e = map.get(id);
        int res = 0;
        if (e == null) {
            return res;
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(e);
        while (!queue.isEmpty()) {
            Employee temp = queue.poll();
            res += temp.importance;
            for(int n : temp.subordinates){
                queue.offer(map.get(n));
            }
        }

        return res;
    }

}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}