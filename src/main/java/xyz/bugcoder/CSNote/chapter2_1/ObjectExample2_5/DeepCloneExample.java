package xyz.bugcoder.CSNote.chapter2_1.ObjectExample2_5;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter2_1.ObjectExample2_5
 * @Description: 深度复制，使用的是不同的对象
 * @Date: 2019-10-12 15:40
 * @Author: Wyj
 */
public class DeepCloneExample implements Cloneable {

    private int[] arr;

    public void set(int index, int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    public DeepCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {

        DeepCloneExample result = (DeepCloneExample) super.clone();
        result.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result.arr[i] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        DeepCloneExample e = new DeepCloneExample();
        DeepCloneExample e2 = null;

        try {
            e2 = e.clone();
        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }

//        for (Integer i : e.arr) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println();
//
//        for (Integer i : e2.arr) {
//            System.out.print(i + " ");
//        }

        e.set(2, 22);
        // 使用的是不同的对象
        System.out.println(e.get(2));
        System.out.println(e2.get(2));
    }

}
