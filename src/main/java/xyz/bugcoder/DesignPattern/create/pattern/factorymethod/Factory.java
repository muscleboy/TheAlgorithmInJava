package xyz.bugcoder.DesignPattern.create.pattern.factorymethod;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.pattern.factorymethod
 * @author: Weiyj
 * @Description: 工程方法模式
 * @createTime 2020-10-29 15:17
 */

// 工厂方法模式 是简单工厂模式的进一步抽象和推广。由于使用了面向对象的多态性，工厂方法模式保持了简单工厂模式的优点，而且克服了它的缺点。
// 在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。这个核心类仅仅负责给出具体工厂必须实现的接口，
// 而不负责产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。

// 优点：
// 1.增加新的产品类时无须修改现有系统，并封装了产品对象的创建细节，系统具有良好的灵活性和可扩展性
// 缺点：
// 2.增加新产品的同时需要增加新的工厂，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性
// 使用情况：
// 1.适用情况包括：一个类不知道它所需要的对象的类；一个类通过其子类来指定创建哪个对象；
// 2.将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定。
public abstract class Factory {

    abstract Product factoryMethod();

    public static void main(String[] args) {
        // 通过具体的工厂，调用工厂方法，生产具体的类
        Factory1 f1 = new Factory1();
        Factory2 f2 = new Factory2();
        Product1 p1 = f1.factoryMethod();
        Product2 p2 = f2.factoryMethod();
        p1.show();
        p2.show();
    }

}
