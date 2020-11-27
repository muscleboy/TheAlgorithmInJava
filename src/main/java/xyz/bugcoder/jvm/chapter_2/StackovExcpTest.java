package xyz.bugcoder.jvm.chapter_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.bugcoder.jvm.chapter_2
 * @author: Weiyj
 * @Description: 栈溢出异常演示
 * @createTime 2020-11-27 20:10
 */
public class StackovExcpTest {

    private static int count = 1;

    // 默认情况下 count: 10822
    // 修改虚拟机栈大小 -Xss256k, count: 1874
    public static void main(String[] args) {
//        System.out.println(count);
//        count ++;

        // 不断递归调用就会 soe 了
//        main(args);

        // 写个死循环就 oom 了
        List<String> list = new ArrayList<>();
        while (true){
            list.add("1");
        }

    }

}
