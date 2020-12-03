package xyz.bugcoder.leetcode_pp.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Package: xyz.bugcoder.leetcode_pp.design
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-03 10:10
 */
public class RandomizedSet_Mid_380 {

    private List<Integer> list;
    // <value, index>
    private HashMap<Integer, Integer> map;

    private Random random;

    public RandomizedSet_Mid_380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    // 最后一个位置的值 赋给 要删除位置，也就是交换
    // 然后再删除最后一个元素
    public boolean remove(int val) {
        // <value, index>，删除 key, 返回 value
        Integer index = map.remove(val);
        if (index == null){
            return false;
        }

        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);
        if (lastIndex != index){
            // 交换
            list.set(index, lastElement);
            map.put(lastElement, index);
        }
        list.remove(lastIndex);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet_Mid_380 r = new RandomizedSet_Mid_380();
        System.out.println(r.insert(1));
        System.out.println(r.remove(2));
        System.out.println(r.insert(2));
        System.out.println(r.getRandom());
    }

}
