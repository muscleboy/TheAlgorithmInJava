package xyz.bugcoder.CSNote.chapter2_1.ObjectExample2_5;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter2_1.ObjectExample2_5
 * @Description: 使用clone()复制对象，需要类型转换，还会抛出异常，代价太高
 * @Date: 2019-10-12 15:54
 * @Author: Wyj
 */
public class CloneConstructExample {

    private int[] arr;

    public CloneConstructExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    // 通过构造函数来实现复制
    public CloneConstructExample(CloneConstructExample original) {
        arr = new int[original.arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    public static void main(String[] args) {
        CloneConstructExample e = new CloneConstructExample();
        CloneConstructExample e2 = new CloneConstructExample(e);
        e.set(2, 22);
        // 2
        System.out.println(e2.get(2));
    }

}
