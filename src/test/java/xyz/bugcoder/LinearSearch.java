package xyz.bugcoder;

import org.junit.Test;

/**
 * @Package: xyz.bugcoder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2019-07-19 10:41
 */
public class LinearSearch {

    public int search(int e){

        int index = -1;
        int[] arr = new int[]{2,4,6,7,9,0,78};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {

                index = i;
                break;
            }
        }
        return index;
    }
}
