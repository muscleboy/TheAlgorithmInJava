package xyz.bugcoder.DesignPattern.principle.DependencyInversion;

/**
 * @Package: xyz.bugcoder.DesignPattern.principle.DependencyInversion
 * @author: Weiyj
 * @Description: 依赖倒置原则
 * @createTime 2020-10-19 14:41
 */

// 存在的问题：
// 当需求改变时，比如要接收微信，QQ的信息等，
// 需要新增WeChat，QQ等类，Person也需要添加对应的方法
// 解决思路：
// 引入一个抽象的接口IReceiver，需要新增类时，只需要实现IReceiver这个接口即可
//
public class DependencyInversion {

    public static void main(String[] args) {
        Person p = new Person();
        p.receive(new Email());
    }

}

class Email{
    public String getInfo(){
        return "receive msg";
    }
}

class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}
