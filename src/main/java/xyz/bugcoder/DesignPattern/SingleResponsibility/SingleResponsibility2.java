package xyz.bugcoder.DesignPattern.SingleResponsibility;

/**
 * @Package: xyz.bugcoder.DesignPattern.SingleResponsibility
 * @author: Weiyj
 * @Description: 设计原则-单一职责原则(一个类只干一件事)
 * @createTime 2020-10-18 15:28
 */
public class SingleResponsibility2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        WaterVehicle waterVehicle = new WaterVehicle();
        AirVehicle airVehicle = new AirVehicle();
        roadVehicle.run("汽车🚘");
        waterVehicle.run("轮船⛴");
        airVehicle.run("飞机✈️");
    }

}

// 交通工具类
// 根据单一职责原则 对SingleResponsibility进行改进，
// 1.对每个类进行拆分(分解)

// 虽然符合单一职责原则，但是对原来的类改动较大，可能会影响到原先写好的功能
class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " 在公路上跑.....");
    }
}

class WaterVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " 在水上跑.....");
    }
}

class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " 在天空中跑.....");
    }
}