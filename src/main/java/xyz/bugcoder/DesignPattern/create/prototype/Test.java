package xyz.bugcoder.DesignPattern.create.prototype;

import xyz.bugcoder.DesignPattern.create.prototype.normal.QuestionController;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.prototype
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 15:05
 */
public class Test {

    @org.junit.Test
    public void test(){

        QuestionController questionBankController = new QuestionController();

        System.out.println(questionBankController.createPaper("花花", "1000001921032"));

        System.out.println(questionBankController.createPaper("⾖⾖", "1000001921051"));

        System.out.println(questionBankController.createPaper("⼤宝", "1000001921987"));

    }

    @org.junit.Test
    public void test2(){

        xyz.bugcoder.DesignPattern.create.prototype.pattern.QuestionController quetionController = new xyz.bugcoder.DesignPattern.create.prototype.pattern.QuestionController();
        try {
            System.out.println(quetionController.createPaper("花花", "1000001921032"));
            System.out.println(quetionController.createPaper("⾖⾖", "1000001921051"));
            System.out.println(quetionController.createPaper("⼤宝", "1000001921987"));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
