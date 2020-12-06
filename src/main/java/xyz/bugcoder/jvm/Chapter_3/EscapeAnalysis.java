package xyz.bugcoder.jvm.Chapter_3;

/**
 * @Package: xyz.bugcoder.jvm.Chapter_3
 * @author: Weiyj
 * @Description: 逃逸分析
 * @createTime 2020-12-06 20:06
 */

// 没有发生逃逸分析，内存就会在栈上分配；反之就会在堆上分配(默认，并且大多数情况下都是 Eden 区)

// 那怎么判断有没有发生逃逸分析了呢？
//  看 new 的对象实体是否会在方法外被调用，是就会逃逸；反之..

// -XX:+DoEscapeAnalysis   显式开启逃逸分析，JDK7 以后默认开启
// -XX:+PrintEscapeAnalysis   查看逃逸分析

// 所以日常开发时，能使用局部变量解决的，就不要在方法外定义新的变 量
public class EscapeAnalysis {

    private EscapeAnalysis obj;

    // 方法返回obj对象，会逃逸
    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }

    // 也会
    public void setObj(){
        this.obj = new EscapeAnalysis();
    }

    // 不会
    public void useEscapeAnalisys(){
        EscapeAnalysis e = new EscapeAnalysis();
    }

    // 会
    public void useEscapeAnalisys2(){
        EscapeAnalysis e = getInstance();
    }

    public static void main(String[] args) {
    }

}
