package xyz.bugcoder.util;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.util
 * @Description: 使用array数组来实现栈
 * @Date: 2019/9/4 20:12
 * @Author: Wyj
 */
public class MyStack2 {

    int[] arr;

    public MyStack2() {

        arr = new int[0];
    }

    // 进栈
    public void push(int e){

        // 创建一个新的数组，长度为原数组.length + 1
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {

            newArr[i] = arr[i];
        }

        newArr[arr.length] = e;
        arr = newArr;
    }

    // 出栈
    public void pop(){

        // 创建一个新的数组，长度为原数组.length - 1
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {

            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    // 查看栈顶元素
    public void peek(){

        if (arr.length <= 0){

            throw new RuntimeException("数组越界");
        }

        System.out.println(arr[arr.length - 1]);
    }

    // 栈是否为空
    public boolean isEmpty(){

        return arr.length == 0;
    }

}
