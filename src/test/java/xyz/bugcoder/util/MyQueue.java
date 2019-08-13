package xyz.bugcoder.util;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.util
 * @author: Weiyj
 * @Description: 队列，先进先出
 * @createTime 2019-07-19 13:41
 */
public class MyQueue {

    int[] arr;

    public MyQueue() {
        arr = new int[0];
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 14:17
    * @Desc: 入队，添加到数组末尾
    * @Param:
    * @Return:
    **/
    public void add(int e){

        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        // 在数组末尾添加元素e
        newArr[arr.length] = e;
        // 替换掉原来的数组
        arr = newArr;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 14:18
    * @Desc: 出队，取出队头元素，并且删除
    * @Param:
    * @Return:
    **/
    public void poll(){

        int e = arr[0];
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {

            // 取出第一位，所以这里从第二位开始复制
            newArr[i] = arr[i + 1];
        }

        arr = newArr;
        System.out.println(e);
    }

    public void show(){

        System.out.println(Arrays.toString(arr));
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-20 10:36
    * @Desc: 判断队列是否为空
    * @Param:
    * @Return:
    **/
    public boolean isEmpty(){

        return arr.length == 0;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-20 10:37
    * @Desc: 查看队首元素
    * @Param:
    * @Return:
    **/
    public int peek(){

        return arr[0];
    }

}
