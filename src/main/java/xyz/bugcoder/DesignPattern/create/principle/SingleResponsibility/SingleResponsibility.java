package xyz.bugcoder.DesignPattern.create.principle.SingleResponsibility;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.principle.SingleResponsibility
 * @author: Weiyj
 * @Description: 设计原则-单一职责原则(一个类只干一件事)
 * @createTime 2020-10-18 15:28
 */
public class SingleResponsibility {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车🚘");
        vehicle.run("轮船⛴");
        vehicle.run("飞机✈️");
    }

}

// 交通工具类
// 类级别上违反单一职责原则
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " 在公路上跑.....");
    }
}
