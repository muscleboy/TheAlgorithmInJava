package xyz.bugcoder.concurrent.heima_7;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * @Package: xyz.bugcoder.concurrent.heima_7
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-28 15:56
 */

@Slf4j
public class SimpleDateFormatTest {

    static String format = "yyyy-MM-dd";

    // 线程不安全
    static SimpleDateFormat sdf = new SimpleDateFormat(format);

    // Java8 不可变类，线程安全
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);


    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                synchronized (sdf){
//                    try {
//                        log.info("date: " + sdf.parse("2020-11-28"));
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                log.info("date: " + dtf.parse("2020-11-28"));
            }).start();
        }

    }

}
