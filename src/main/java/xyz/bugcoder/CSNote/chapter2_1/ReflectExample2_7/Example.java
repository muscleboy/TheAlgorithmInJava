package xyz.bugcoder.CSNote.chapter2_1.ReflectExample2_7;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.CSNote.chapter2_1.ReflectExample2_7
 * @Description:
 * @Date: 2019-10-14 10:22
 * @Author: Wyj
 */
public class Example {

    public int id;
    public String name;
    private int MAX_LENGTH = 18;

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int add(int a, int b){

        return a + b;
    }

    private void privateMethod(String a, int b){

        System.out.println(a + " " + b);
    }

    protected void protectedMethod(String a, int b){

        System.out.println(a + " " + b);
    }

    void defaultMethod(String a, int b){

        System.out.println(a + " " + b);
    }

    public Example(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Example() {
        System.out.println("构造函数");
    }

    public void show(){

        System.out.println("show方法....");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
