package xyz.bugcoder.DesignPattern.create.builder;

import xyz.bugcoder.DesignPattern.create.builder.pattern.Builder;

import java.math.BigDecimal;

import static xyz.bugcoder.DesignPattern.create.builder.normal.DecorationPackageController.getMatterList;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.builder
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-30 17:29
 */

public class Test {

    @org.junit.Test
    public void test1(){
        System.out.println(getMatterList(new BigDecimal("132.52"), 1));
        System.out.println(getMatterList(new BigDecimal("98.25"), 2));
        System.out.println(getMatterList(new BigDecimal("85.43"), 3));
    }

    @org.junit.Test
    public void test2(){
        Builder builder = new Builder();
        System.out.println(builder.levelOne(new BigDecimal(132.52)).getDetail());
        System.out.println(builder.levelTwo(new BigDecimal(98.25)).getDetail());
        System.out.println(builder.levelThree(new BigDecimal(85.43)).getDetail());
    }

}
