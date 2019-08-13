package xyz.bugcoder;

import org.junit.Test;

/**
 * @Package: xyz.bugcoder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-19 10:55
 */
public class BinarySearch {

    public int search(int target){

        int[] arr = new int[]{1,4,5,6,87,98,99,100};

        int begin = 0;
        int end = arr.length - 1;
        int middle = (begin + end)/2;
        int index = -1;

        while (true) {

            if (arr[middle] == target) {

                index = middle;
                break;
            }else {

                if (arr[middle] > target) {

                    end = middle - 1;
                }else {

                    begin = middle + 1;
                }
            }

            middle = (begin + end)/2;
        }
        return index;
    }
}
