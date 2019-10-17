package xyz.bugcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    // 冒泡排序
//    public static void bubbleSort(int[] arr){
//
//        for (int i = 0; i < arr.length; i++) {
//
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//
//                if (arr[j] > arr[j + 1]){
//
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }

    // 快速排序
//    public static void quickSort(int[] arr, int left, int right){
//
//        if (left < right){
//
//            // 左右指针
//           int low = left;
//           int high = right;
//           // 基准值
//           int pivot = arr[left];
//           while (low != high){
//
//               // 右往左，如果 >= pivot，前移
//               while (arr[high] >= pivot && low < high)
//                   high --;
//               // 遇到小于pivot的时候，high替换掉low的值
//               arr[low] = arr[high];
//               // 左往右，如果 <= pivot，后移
//               while (arr[low] <= pivot && low < high)
//                   low ++;
//               // 遇到大于pivot的时候，low替换掉high的值
//               arr[high] = arr[low];
//           }
//           // low位置为 pivot
//           arr[low] = pivot;
//           // 递归小于pivot的部分
//           quickSort(arr, left, low);
//           // 递归大于pivot的部分
//           quickSort(arr, low + 1, right);
//        }
//    }

//    public static void selectSort(int[] arr){
//
//        for (int i = 0; i < arr.length - 1; i++) {
//
//            // 假设一个最小值，来找到真正的最小值
//            int min = i;
//            for (int j = i + 1; j < arr.length; j++) {
//
//                if (arr[j] < arr[min])
//                    // 得到最小值的下标
//                    min = j;
//            }
//
//            // 如果 i != 最小值，则交换位置，就达到排序的效果了
//            if (i != min){
//
//                int temp = arr[min];
//                arr[min] = arr[i];
//                arr[i] = temp;
//            }
//        }
    // 插入排序
//    public static void insertSort(int[] arr){
//        // 从第一位开始
//        for (int i = 1; i < arr.length; i++) {
//            // 记录当前位置的值
//            int temp = arr[i];
//            int j = i;
//            // 当前位<当前位-1，就替换
//            while (j > 0 && temp < arr[j - 1]){
//                arr[j] = arr[j - 1];
//                j --;
//            }
//            arr[j] = temp;
//        }
//    }

    // 希尔排序
//      public static void shellSort(int[] arr){
//          int gap = arr.length/2;
//          while (gap > 0){
//              // 从gap开始，arr.length-gap次
//              for (int i = gap; i < arr.length; i++) {
//                  // i=gap，使得J从0开始，由外层控制次数
//                  for (int j = i - gap; j > 0 ; j -= gap) {
//                      // 交换
//                      if (arr[j] > arr[j + gap]){
//                          int temp = arr[j];
//                          arr[j] = arr[j + gap];
//                          arr[j + gap] = temp;
//                      }
//                  }
//              }
//              // 每次间隔/2减半
//              gap /= 2;
//          }
//      }

    // 选择排序
//    public static void selectSort(int[] arr){
//        // 需要比较n-1次
//        for (int i = 0; i < arr.length; i++) {
//            // 假设一个最小值
//            int min = i;
//            // 从i+1位开始，找到新的最小值
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[min])
//                    min = j;
//            }
//            // 交换位置，第一次将第一小的放到了第一位....
//            if (i != min){
//                int temp = arr[i];
//                arr[i] = arr[min];
//                arr[min] = temp;
//            }
//        }
//    }

    // 剑指offer，替换空格
//    public static String replaceSpaces(String str){
//
//        // 字符串转化成空格
//        char[] str2char = str.toCharArray();
//        // 空格数
//        int spaces = 0;
//        for (char c : str2char) {
//            if (c == ' ')
//                spaces ++;
//        }
//
//        // 新数组的长度：原数组.length + spaces*2
//        char[] result = new char[str2char.length + spaces*2];
//        // 新旧数组的下边 i, j
//        int i = str2char.length - 1;
//        int j = result.length - 1;
//        // 新数组从后往前遍历
//        while (j >= 0){
//
//            // 没遇到空格，照常复制
//            result[j] = str2char[i];
//            // 遇到空格，j='0'，j-1='2',j-2='5'
//            if (str2char[i] == ' '){
//
//                result[j] = '0';
//                result[j - 1] = '2';
//                result[j- 2] = '%';
//                // -2是多出2位
//                j -= 2;
//            }
//            // 依次向前
//            j --;
//            i --;
//        }
//
//        return new String(result);
//    }

    // 统计数组中重复的数字
//    public static void countRepeatNum(int[] arr){
//
//        List<Integer> repeateNums = new ArrayList<>();
//        // 每一位与它的下一位比较
//        for (int i = 0; i < arr.length - 1; i++) {
//            // j = i，表示：当到达第j位的时候，不需要往前比较了，已经比过了
//            for (int j = i; j < arr.length - 1; j++) {
//
//                if (arr[i] == arr[j + 1])
//                    repeateNums.add(arr[i]);
//            }
//        }
//
//        for (Integer i : repeateNums) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }

//  饿汉式单例模式
//    private App() {
//    }
//
//    public static App instance = new App();
//    public static App getInstance(){
//
//        return instance;
//    }

//    懒汉式单例模式
//    private App(){
//    }
//
//    public static App instance = new App();
//    public static App getInstance(){
//
//        if (instance == null)
//            return new App();
//        return instance;
//    }

    // 二分查找
//    public static int binarySearch(int[] arr, int target){
//
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right){
//            int mid = (left + right)/2;
//            if (arr[mid] == target){
//                return mid;
//            }
//            if (arr[mid] > target)
//                right = mid - 1;
//            if (arr[mid] < target)
//                left = mid + 1;
//        }
//        return -1;
//    }

//    public static void nine(){
//        for (int i = 1; i < 10; i++) {
//            for (int j = i; j < 10; j++) {
//                System.out.print(i + "*" + j + "=" + i*j + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args ) {

        int[] arr = new int[]{1,43,645,86,7,4,53,2,76,43,1,4};
//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
//        nine();
//        System.out.println(binarySearch(arr, 9));
//        countRepeatNum(arr);
//        String str = "we are happy ! ";
//        System.out.println(replaceSpaces(str));
//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
        String s = new String("asdf");
        StringBuffer sb = new StringBuffer();
        System.out.println(Arrays.toString(arr));
    }
}
