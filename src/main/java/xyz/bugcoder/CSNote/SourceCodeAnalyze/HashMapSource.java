package xyz.bugcoder.CSNote.SourceCodeAnalyze;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Package: xyz.bugcoder.CSNote.SourceCodeAnalyze
 * @author: Weiyj
 * @Description: hashmap源码学习
 * @createTime 2020-08-27 23:45
 */
public class HashMapSource {

    public static void main(String[] args) {
        HashMapSource m = new HashMapSource();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        map.put("g1001", 1);
        map2.put("g1001", 1);
        System.out.println(Objects.equals(map, map2));
    }

}
