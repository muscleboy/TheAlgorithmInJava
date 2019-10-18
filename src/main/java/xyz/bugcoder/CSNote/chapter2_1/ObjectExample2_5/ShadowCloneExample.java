package xyz.bugcoder.CSNote.chapter2_1.ObjectExample2_5;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter2_1.ObjectExample2_5
 * @Description: 浅复制，同一对象
 * @Date: 2019-10-12 11:43
 * @Author: Wyj
 */
// 实现Cloneable接口，重写Object的protected方法clone()，才能使用clone()
public class ShadowCloneExample implements Cloneable {

    private int[] arr;

    public ShadowCloneExample() {
        arr = new int[10];
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

    @Override
    protected ShadowCloneExample clone() throws CloneNotSupportedException {
        return (ShadowCloneExample) super.clone();
    }

    public static void main(String[] args) {

        ShadowCloneExample e = new ShadowCloneExample();
        ShadowCloneExample e2 = null;

        try {
            e2 = e.clone();
        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }

        e.set(2, 22);
        System.out.println(e2.get(2));
    }

}
