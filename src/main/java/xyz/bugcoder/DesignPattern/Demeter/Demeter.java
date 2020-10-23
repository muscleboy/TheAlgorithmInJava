package xyz.bugcoder.DesignPattern.Demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.DesignPattern.Demeter
 * @author: Weiyj
 * @Description: 迪米特法则
 * @createTime 2020-10-23 15:17
 */
public class Demeter {

    public static void main(String[] args) {
        SchoolManager s = new SchoolManager();
        s.printAllEmployee(new CollegeManager());
    }

}

class Employee{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class CollegeEmployee{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

// CollegeManager直接朋友：CollegeEmployee
class CollegeManager{

    public List<CollegeEmployee> getAll(){
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee e = new CollegeEmployee();
            e.setId(i);
            list.add(e);
        }

        return list;
    }

}

// SchoolManager直接朋友：Employee(返回值), CollegeManager(参数)
class SchoolManager{

    public List<Employee> getAll(){
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee e = new Employee();
            e.setId(i);
            list.add(e);
        }

        return list;
    }

    void printAllEmployee(CollegeManager c){
        // CollegeEmployee以局部变量的方式出现，违反了迪米特法则
        List<CollegeEmployee> collegeEmployeeList = c.getAll();
        System.out.println("----CollegeEmployee2-----");
        for (CollegeEmployee ce : collegeEmployeeList) {
            System.out.println("CollegeEmployee员工ID " + ce.getId());
        }
        List<Employee> employeeList = getAll();
        System.out.println("----Employee2-----");
        for (Employee e : employeeList) {
            System.out.println("Employee员工ID：" + e.getId());
        }
    }

}