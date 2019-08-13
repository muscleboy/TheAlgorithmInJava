package xyz.bugcoder.util;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder.util
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-18 11:08
 */
public class MyArray {
    
    int[] arr;

    public MyArray() {
        arr = new int[0];
    }

    public int size(){
        return arr.length;
    }

    public void add(int element){

        // 准备新数组
        int[] newArr = new int[arr.length + 1];
        // 将旧数组的元素添加到新数组中
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        // 在末尾添加新的元素
        newArr[arr.length] = element;
        // 替换数组
        arr = newArr;
    }

    public void show(){

        System.out.println(Arrays.toString(arr));
    }

    /**
   * @Author: Weiyj
   * @Date: 2019-07-18 11:15
   * @Desc: 在pos位置插入element
   * @Param: 
   * @Return: 
   **/ 
    public void insert(int element, int pos){

        int[] insertArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (pos < 0 || pos > insertArr.length){

                throw new RuntimeException("数组越界了");
            }else {

                //  pos之前
                if (i < pos){

                    insertArr[i] = arr[i];
                }
                // pos之后
                else {

                    insertArr[i + 1] = arr[i];
                }
                insertArr[pos] = element;
            }
        }

        arr = insertArr;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-18 14:16
    * @Desc: 删除给定位置的元素
    * @Param:
    * @Return:
    **/
    public void delete(int pos){

        int[] deleteArr = new int[arr.length - 1];
        for (int i = 0; i < deleteArr.length; i++) {

            if (pos >= 0 || pos <= deleteArr.length){

                if (i < pos) {
                    deleteArr[i] = arr[i];
                }

                if (i >= pos){
                    deleteArr[i] = arr[i + 1];
                }
            }
        }

        arr = deleteArr;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-18 14:27
    * @Desc: 将值为src的地方改为dest
    * @Param:
    * @Return:
    **/
    public void update(int src, int dest){

        arr[src] = dest;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 10:25
    * @Desc: 获取某个元素
    * @Param:
    * @Return:
    **/
    public Object get(int pos){

        return arr[pos];
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 12:27
    * @Desc: 数组线性查找
    * @Param:
    * @Return:
    **/
    public int search(int target){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {

                return i;
            }
        }

        // 没找到
        return -1;
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-19 12:32
    * @Desc: 数组二分查找，前提是：数组有序
    * @Param:
    * @Return:
    **/
    public int binarySearch(int target){

        int begin = 0;
        int end = arr.length - 1;
        int middle = (begin + end)/2;

        while (true) {

            // 当元素不存在时
            if (begin >= end) {

                return -1;
            }

            if (arr[middle] == target) {

                return middle;
            }else {
                // 中间位置的值 > 要查找的值
                if (arr[middle] > target) {

                    end = middle - 1;
                }
                // 中间位置的值 < 要查找的值
                else {

                    begin = middle + 1;
                }
            }

            middle = (end + begin)/2;
        }
    }

}
