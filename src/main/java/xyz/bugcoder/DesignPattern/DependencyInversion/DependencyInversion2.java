package xyz.bugcoder.DesignPattern.DependencyInversion;

/**
 * @Package: xyz.bugcoder.DesignPattern.DependencyInversion
 * @author: Weiyj
 * @Description: 依赖倒置原则(体现出面向接口编程思想)
 * @createTime 2020-10-19 14:41
 */

// 存在的问题：
// 当需求改变时，比如要接收微信，QQ的信息等，
// 需要新增WeChat，QQ等类，Person也需要添加对应的方法
// 解决思路：
// 引入一个抽象的接口IReceiver，需要新增类时，只需要实现IReceiver这个接口即可
//
// 依赖倒置原则
// 1.高层模块不应该依赖底层模块，两者应该依赖其抽象
// 2.抽象不应该依赖细节，细节应该依赖抽象
// 3.依赖倒转原则的中心思想：面向接口编程
// 4.相对于细节的多变性，抽象的东西要稳定的多，以抽象为基础搭建的架构比以细节要稳的多，在Java中，抽象是指：接口或抽象类，细节是指：实现类
// 5.使用接口或抽象类的目的是制定好规范，而不设计任务具体的操作，具体的细节由实现类去完成
public class DependencyInversion2 {

    public static void main(String[] args) {
        // 1.接口形式
//        Person2 p = new Person2();
//        p.receive(new Email2());
//        p.receive(new Wechat());
//        p.receive(new QQ());

        // 2.构造函数形式
//        XiaoMi xiaoMi = new XiaoMi();
//        OpenAndClose openAndClose = new OpenAndClose(xiaoMi);
//        openAndClose.open();

        // 3.通过setter
        XiaoMi xiaoMi = new XiaoMi();
        OpenAndClose openAndClose = new OpenAndClose();
        // 这里需要先set，不然会空指针
        openAndClose.setItv(xiaoMi);
        openAndClose.open();
    }

}

// 1.通过接口形式 实现依赖倒转

//interface IReceiver{
//    String getInfo();
//}
//
//class Email2 implements IReceiver{
//    public String getInfo(){
//        return "receive msg";
//    }
//}
//
//class Wechat implements IReceiver{
//    public String getInfo(){
//        return "receive wechat";
//    }
//}
//
//class QQ implements IReceiver{
//    public String getInfo(){
//        return "receive QQ";
//    }
//}

//class Person2{
//    // 依赖接口
//    public void receive(IReceiver iReceiver){
//        System.out.println(iReceiver.getInfo());
//    }
//}

// 2.通过构造函数实现

//interface IOpenAndClose{
//    void open();
//}
//
//interface ITV {
//    void play();
//}
//
//class OpenAndClose implements IOpenAndClose{
//
//    ITV itv;
//
//    public OpenAndClose(ITV itv) {
//        this.itv = itv;
//    }
//
//    @Override
//    public void open() {
//        itv.play();
//    }
//}
//
//class XiaoMi implements ITV{
//
//    @Override
//    public void play() {
//        System.out.println("Xiaomi TV open!");
//    }
//}

// 3.通过setter
interface IOpenAndClose{
    void open();
    void setItv(ITV itv);
}

interface ITV {
    void play();
}

class OpenAndClose implements IOpenAndClose{

    ITV tv;

    public void setItv(ITV itv) {
        this.tv = itv;
    }

    public void open() {
        this.tv.play();
    }
}

class XiaoMi implements ITV{

    @Override
    public void play() {
        System.out.println("Xiaomi TV open!");
    }
}