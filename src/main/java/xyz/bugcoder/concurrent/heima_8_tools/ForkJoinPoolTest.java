package xyz.bugcoder.concurrent.heima_8_tools;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Package: xyz.bugcoder.concurrent.heima_8_tools
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-29 20:31
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {

        // 默认为CPU 核心数个线程
        ForkJoinPool pool = new ForkJoinPool();
//        System.out.println(pool.invoke(new MyTask(5)));
        System.out.println(pool.invoke(new MyTask2(1, 10)));
    }

}


// 分治(递归)   将一个任务不断拆分成小人物去执行，最后进行结果整合
// RecursiveTask有返回值， 不需要返回值可以使用 RecursiveAction
@Slf4j
class MyTask extends RecursiveTask<Integer> {

    private int n;

    @Override
    public String toString() {
        return "{" + n + '}';
    }

    public MyTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {

        if (n == 1){
            log.info("join() {}", n);
            return 1;
        }

        MyTask t = new MyTask(n - 1);
        t.fork();
        log.info("fork() {} + {}", n, t);

        int res = t.join() + n;
        log.info("join() {} + {} = {}", n, t, res);

        return res;
    }
}

@Slf4j
class MyTask2 extends RecursiveTask<Integer> {

    private int begin;
    private int end;

    @Override
    public String toString() {
        return "{" + begin + "," + end + '}';
    }

    public MyTask2(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        // 相当于递归的终止条件
        // 5 5
        if (begin == end){
            log.debug("join() {}", begin);
            return begin;
        }

        int mid = (begin + end)/2;
        MyTask2 t1 = new MyTask2(begin, mid);
        t1.fork();
        MyTask2 t2 = new MyTask2(mid + 1, end);
        t2.fork();

        log.debug("fork() {} + {} = ?", t1, t2);
        int res = t1.join() + t2.join();
        log.debug("join() {} + {} = {}", t1, t2, res);

        return res;
    }
}