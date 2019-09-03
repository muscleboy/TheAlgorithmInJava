package xyz.bugcoder.util;

/**
 * @Package: xyz.bugcoder.util
 * @author: Weiyj
 * @Description: 栈，先进后出
 * @createTime 2019-07-19 12:43
 */
public class MyStack  {

    int[] arr;

    public MyStack() {
        arr = new int[0];
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 13:01
    * @Desc: 压栈，向栈尾添加元素e
    * @Param: e
    * @Return: void
    **/
    public void push(int e){

        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {

            newArr[i] = arr[i];
        }

        // 向数组末尾添加元素e
        newArr[arr.length] = e;
        arr = newArr;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 13:27
    * @Desc: 取出栈顶元素(元素会被删除)
    * @Param:
    * @Return:
    **/
    public int pop(){

        if (arr.length == 0){
            throw new RuntimeException("栈为空");
        }

        int e = arr[arr.length - 1];
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            // 因为栈顶元素在最后，循环newArr.length直接取，取不到最后一位
            newArr[i] = arr[i];
        }

        arr = newArr;
        return e;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 13:30
    * @Desc: 查看栈顶元素(元素不会被删除)
    * @Param:
    * @Return:
    **/
    public void peek(){

        if (arr.length == 0) {

            throw new RuntimeException("栈为空");
        }
        System.out.println(arr[arr.length - 1]);
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 13:36
    * @Desc: 判断栈是否为空
    * @Param:
    * @Return:
    **/
    public boolean isEmpty(){

        return arr.length == 0;
    }

}
