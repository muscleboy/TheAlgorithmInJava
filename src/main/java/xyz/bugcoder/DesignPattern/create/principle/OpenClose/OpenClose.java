package xyz.bugcoder.DesignPattern.create.principle.OpenClose;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.principle.OpenClose
 * @author: Weiyj
 * @Description: 开闭原则
 * @createTime 2020-10-22 15:06
 */
public class OpenClose {

    public static void main(String[] args) {
        GraphicEditor g = new GraphicEditor();
        g.drawShape(new Rectangle());
        g.drawShape(new Circle());
        g.drawShape(new Other());
    }

}

class GraphicEditor{

    public void drawShape(Shape s){
        if (s.type == 1){
            drawRectangle(s);
        }else if (s.type == 2){
            drawCircle(s);
        }
        // 新增一个类时   -- 修改
        else if (s.type == 3){
            drawOther(s);
        }
    }

    public void drawRectangle(Shape s){
        System.out.println("绘制矩形");
    }

    public void drawCircle(Shape s){
        System.out.println("绘制圆形");
    }

    // 新增一个类时   -- 修改
    public void drawOther(Shape s){
        System.out.println("绘制其他图形");
    }

}

class Shape{
    int type;
}

class Rectangle extends Shape{
    public Rectangle() {
        super.type = 1;
    }
}

class Circle extends Shape{
    public Circle() {
        super.type = 2;
    }
}

// 新增一个类
class Other extends Shape{
    public Other() {
        super.type = 3;
    }
}
