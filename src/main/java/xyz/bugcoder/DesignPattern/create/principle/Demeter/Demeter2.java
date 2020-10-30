package xyz.bugcoder.DesignPattern.create.principle.Demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.principle.Demeter
 * @author: Weiyj
 * @Description: 迪米特法则
 * @createTime 2020-10-23 15:17
 */

// 1.一个对象应该对其他对象保持最少的了解
// 2.类与类的关系越密切，耦合度越大
// 3.迪米特法则又称 最少知道原则，即一类对自己依赖的类知道的越少越好，
//   也就是说，对于被依赖的类不管多么复杂，都尽量封装在类的内部，除public方法除外，不对外泄露任何信息
// 4.只与直接朋友通信
// 5.直接朋友：每个对象都会与其他对象耦合，只要两个对象之间有耦合关系，这两个对象就是 直接朋友关系
//   耦合的方式：依赖，关联，组合，聚合等; 我们称出现在 成员变量、方法参数、方法返回值中为类的直接朋友
//   出现在局部变量中不是直接朋友关系， 陌生的类最好不要以局部变量的形式出现在类的内部

// 核心：降低对象之间的耦合，而不是要求完全没有依赖关系
public class Demeter2 {

    public static void main(String[] args) {
        SchoolManager2 s = new SchoolManager2();
        s.printAllEmployee(new CollegeManager2());
    }

}

class Employee2 {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class CollegeEmployee2 {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class CollegeManager2 {

    public List<CollegeEmployee2> getAll(){
        List<CollegeEmployee2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee2 e = new CollegeEmployee2();
            e.setId(i);
            list.add(e);
        }

        return list;
    }

    public void printCollegeEmployee(){
        List<CollegeEmployee2> collegeEmployeeList = getAll();
        System.out.println("----CollegeEmployee2-----");
        for (CollegeEmployee2 ce : collegeEmployeeList) {
            System.out.println("CollegeEmployee员工ID " + ce.getId());
        }
    }

}

class SchoolManager2{

    public List<Employee2> getAll(){
        List<Employee2> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee2 e = new Employee2();
            e.setId(i);
            list.add(e);
        }

        return list;
    }

    void printAllEmployee(CollegeManager2 c){
        System.out.println("=====遵守迪米特法则=====");
        // 解决方案：将原来的方法封装到CollegeManager2中
        c.printCollegeEmployee();
        List<Employee2> employeeList = getAll();
        System.out.println("----Employee2-----");
        for (Employee2 e : employeeList) {
            System.out.println("Employee员工ID：" + e.getId());
        }
    }

}