package xyz.bugcoder.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Package: xyz.bugcoder.jianzhioffer
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-02 11:59
 */
public class MaxQueue_Mid_59 {

    Deque<Integer> res, max;
    public MaxQueue_Mid_59() {
        res = new LinkedList<Integer>();
        max = new LinkedList<Integer>();
    }

    public int max_value() {
        if(max.isEmpty()) return -1;
        return max.peekFirst();
    }

    public void push_back(int value) {
        res.addLast(value);
        while(!max.isEmpty() && max.peekLast()<value) max.removeLast();
        max.addLast(value);
    }

    public int pop_front() {
        if(res.isEmpty()) return -1;
        int temp = res.peekFirst();
        if(temp == max.peekFirst()) max.removeFirst();
        res.removeFirst();
        return temp;
    }

    @Override
    public String toString() {
        return "MaxQueue_Mid_59{" +
                "res=" + res +
                ", max=" + max +
                '}';
    }

    public static void main(String[] args) {
        MaxQueue_Mid_59 q = new MaxQueue_Mid_59();
        System.out.println(q.max_value());
        System.out.println(q.pop_front());
        System.out.println(q.pop_front());
        q.push_back(94);
        q.push_back(16);
        q.push_back(89);
        System.out.println(q);
        System.out.println(q.pop_front());
        System.out.println(q);
        q.push_back(22);
        System.out.println(q);
        System.out.println(q.pop_front());
    }

}
