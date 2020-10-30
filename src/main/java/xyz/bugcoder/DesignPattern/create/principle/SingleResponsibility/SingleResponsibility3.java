package xyz.bugcoder.DesignPattern.create.principle.SingleResponsibility;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.principle.SingleResponsibility
 * @author: Weiyj
 * @Description: 设计原则-单一职责原则(一个类只干一件事)
 * @createTime 2020-10-18 15:28
 */

// 单一职责原则的注意事项和细节:
// 1.降低类的复杂度，一个类只负责一个职责(功能)
// 2.提高类的可读性、可维护性
// 3.降低需求变更时引起的风险
// 4.只有在逻辑足够简单的情况下，才可以在类级别违反单一职责原则；只有在方法足够少的情况下，才可以在方法级别保持单一职责原则
public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("汽车🚘");
        vehicle.run2("轮船⛴");
        vehicle.run3("飞机✈️");
    }

}

// 交通工具类
// 虽然在类级别上违反单一职责原则，但是在方法级别上符合的单一职责原则，
// 并且只是在原有代码的基础上进行拓展，添加新功能，不会影响到已经发出去的功能。
class Vehicle2{
    public void run(String vehicle){
        System.out.println(vehicle + " 在公路上跑.....");
    }

    public void run2(String vehicle){
        System.out.println(vehicle + " 在水中跑.....");
    }

    public void run3(String vehicle){
        System.out.println(vehicle + " 在天空上跑.....");
    }

}