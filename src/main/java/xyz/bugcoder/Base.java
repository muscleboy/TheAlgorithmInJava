package xyz.bugcoder;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder
 * @Description:
 * @Date: 2019-10-15 20:02
 * @Author: Wyj
 */
public class Base {

    static class Counter
    {
        private static int count = 0;
        public int increment()
        {
            return count++;
        }
        public int anotherIncrement()
        {
            return ++count;
        }
    }
    public static void main(String[] args) throws MalformedURLException {

        
    }

}

