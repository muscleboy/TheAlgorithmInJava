package xyz.bugcoder.DesignPattern.create.factory;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.factory
 * @author: Weiyj
 * @Description:  简单工厂模式
 * @createTime 2020-10-25 17:11
 */

// 优点：
// 将具体生产产品的逻辑封装，客户端Client在使用时，只需要通过createProduct传入参数，对生产的具体实现并不关心
// 1.工厂类含有必要的判断逻辑，可以决定在什么时候创建哪一个产品类的实例，客户端可以免除直接创建产品对象的责任，
//   而仅仅“消费”产品；简单工厂模式通过这种做法实现了对责任的分割，它提供了专门的工厂类用于创建对象。
// 2.客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可，对于一些复杂的类名，通过简单工厂模式可以减少使用者的记忆量。
// 3.通过引入配置文件，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性。
//
// 缺点：
// 1.工厂类集中了所有产品创建逻辑，一旦不能正常工作，整个系统都要受到影响。
// 2.使用简单工厂模式将会增加系统中类的个数，在一定程序上增加了系统的复杂度和理解难度。
// 3.系统扩展困难，一旦添加新产品就不得不修改工厂逻辑(违背OCP原则)，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护。
//
// 使用场景：
// 1.工程类负责创建的类少，不会造成工程方法逻辑复杂
// 2.客户端只需要知道类型所对应的参数，对对象的创建细节不需要制定
//
// JDK源码中的使用：java.text.DateFormat，javax.crypto.KeyGenerator
public class SimpleFactory {

    public Product createProduct(int type){

        switch (type){
            case 1:
                return new ProductA();
            case 2:
                return new ProductB();
            case 3:
                return new ProductC();
        }

        return null;
    }

}
