package xyz.bugcoder.jvm.chapter_6;

/**
 * @Package: xyz.bugcoder.jvm.chapter_6
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-12-20 20:34
 */
public class SonTest {

    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.x);
    }

}

/*
   非静态成员变量初始化过程
   1.默认值初始化，如 Integer 默认为0
   2.显示初始化 / 代码块初始化
   3.构造器初始化
   4.有了对象之后，对象.属性 或 对象.方法 进行赋值
 */
class Father{

    int x = 10;

    public Father() {
        this.print();
        this.x = 20;
    }

    public void print(){
        System.out.println("Father.x = " + x);
    }
}

class Son extends Father{

    int x = 30;

    public Son() {
        this.print();
        this.x = 40;
    }

    public void print(){
        System.out.println("Son.x = " + x);
    }
}
