package xyz.bugcoder.DesignPattern.structure.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.visitor
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-12 16:30
 */
public class Test {

    private Logger logger = LoggerFactory.getLogger(Parent.class);

    @org.junit.Test
    public void test(){
        DataView view = new DataView();
        logger.info("\r\n家⻓视⻆角访问：");
        view.show(new Parent());

        logger.info("\r\n校长视⻆角访问：");
        view.show(new Principal());
    }

}
