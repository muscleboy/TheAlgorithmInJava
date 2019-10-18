package xyz.bugcoder.CSNote.chapter2_1.ObjectExample2_5;

/**
 * Create with IDEA.
 *
 *  @Package: xyz.bugcoder.CSNote.chapter2_1.ObjectExample2_5
 * @Description:
 * @Date: 2019-10-12 11:07
 * @Author: Wyj
 */
public class CloneExample implements Cloneable{

    private int a;
    private int b;

    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        // 调用父类(Object)的clone
        return (CloneExample) super.clone();
    }

    public static void main(String[] args){
        CloneExample e1 = new CloneExample();
        // 没有实现Cloneable接口，报错CloneNotSupportedException
        // 必须实现Cloneable接口的clone()，才能使用clone()
        try {
            CloneExample e2 = e1.clone();
            System.out.println(e1);
            System.out.println(e2);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

}
