package xyz.bugcoder.DesignPattern.OpenClose;

/**
 * @Package: xyz.bugcoder.DesignPattern.OpenClose
 * @author: Weiyj
 * @Description: 开闭原则
 * @createTime 2020-10-22 15:06
 */

// 1.编程中最基础，最重要的原则
// 2.一个类、模块和函数应该对拓展开放（），对修改关闭。用抽象构建框架，用实现拓展细节
// 3.当需求发生变化时，尽量通过拓展原来代码来应对变化，而不是修改现在代码
// 4.使用设计模式的目的就是 遵循开闭原则
public class OpenClose2 {

    public static void main(String[] args) {
        GraphicEditor2 g = new GraphicEditor2();
        g.draw(new Rectangle2());
        g.draw(new Circle2());
        g.draw(new Other2());
    }

}

class GraphicEditor2{

    public void draw(Shape2 s){
        s.drawShape();
    }

}

interface Shape2{
//    int type;
    void drawShape();
}

class Rectangle2 implements Shape2{

    @Override
    public void drawShape() {
        System.out.println("绘制矩形");
    }
}

class Circle2 implements Shape2{

    @Override
    public void drawShape() {
        System.out.println("绘制圆形");
    }
}

// 新增一个类时
class Other2 implements Shape2{

    @Override
    public void drawShape() {
        System.out.println("绘制其他图形");
    }
}
