package xyz.bugcoder.util;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.util
 * @Description: 队列实现
 * @Date: 2019/9/5 20:53
 * @Author: Wyj
 */
public class MyQueue2 {

    int[] arr;

    public MyQueue2(){

        arr = new int[0];
    }

    // 入队
    public void add(int e){

        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {

            newArr[i] = arr[i];
        }

        newArr[arr.length] = e;
        arr = newArr;
    }

    // 出队
    public int poll(){

        // 取出队首
        int e = arr[0];
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {

            newArr[i] = arr[i + 1];
        }

        arr = newArr;
        return e;
    }

    // 查看对头
    public int peek(){

        return arr[0];
    }

    // 查看队列的元素
    public void element(){

        for (int e : arr) {

            System.out.print(e + " ");
        }
        System.out.println();
    }

    // 判断队列是否为空
    public boolean isEmpty(){

        return arr.length == 0;
    }

}
