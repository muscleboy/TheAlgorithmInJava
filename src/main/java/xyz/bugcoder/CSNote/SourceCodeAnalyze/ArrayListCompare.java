package xyz.bugcoder.CSNote.SourceCodeAnalyze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Package: xyz.bugcoder.CSNote.SourceCodeAnalyze
 * @author: Weiyj
 * @Description: ArrayList Vector比较
 * @createTime 2020-08-27 23:05
 */
public class ArrayListCompare {

    public static void main(String[] args) {
        // List线程安全解决方案
        // 1.得到一个线程安全的List
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        // 2.concurrent 并发包下的 CopyOnWriteArrayList，读(原数组)写(复制的数组)分离
        // 适合：读多写少场景，不适合：内存敏感、实时性要求高
        // 缺陷：因为复制数组，所以内存占用为原来2倍; 读操作不实时性，因为部分写操作的数据为同步到读数组中
        List<String> strings = new CopyOnWriteArrayList<>();
    }

}
