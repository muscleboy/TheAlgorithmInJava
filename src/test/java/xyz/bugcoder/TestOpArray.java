package xyz.bugcoder;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Package: xyz.bugcoder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-18 10:03
 */
public class TestOpArray {

    /**
    * @Author: Weiyj
    * @Date: 2019-07-18 10:14
    * @Desc: 向固定长度的数组添加数据
    * @Param:
    * @Return:
    **/
    @Test
    public void addElementToArray(){

        // 原数组
        int[] arr1 = new int[]{1,2,3};
        // 新数组
        int[] arr2 = new int[arr1.length + 1];
        // 将原数组的元素添加到 新数组中
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }

        // 准备要添加的元素
        int a = 10;
        arr2[arr1.length] = a;

        // 将新数组指向原数组
        arr1 = arr2;
        System.out.println(Arrays.toString(arr1));
    }

    /**
    * @Author: Weiyj
    * @Date: 2019-07-18 10:49
    * @Desc: 从数组中删除元素
    * @Param:
    * @Return:
    **/
    @Test
    public void delElementFromArray(){

        int index;
        // 要删除的数组
        int[] arr1 = new int[]{12,21,33,44,51,68};
        // 删除之后的数组
        int[] arr2 = new int[arr1.length - 1];

        System.out.println(Arrays.toString(arr1));
        // 要删除的元素
        int a = 12;

        for (int i = 0; i < arr1.length; i++) {

            // 获取要删除元素的下标
            if (arr1[i] == a){

                index = i;
                // < index，直接添加
                for (int j = 0; j < index; j++) {

                    arr2[j] = arr1[j];
                }
//                System.out.println(Arrays.toString(arr2));
                // > index，从index + 1位置开始
                for (int k = index + 1; k < arr1.length; k++) {

                    // 将arr1[n] 赋值给 arr2[n-1]
                    arr2[k-1] = arr1[k];
                }
            }
        }

        arr1 = arr2;
        System.out.println(Arrays.toString(arr1));
    }

}
