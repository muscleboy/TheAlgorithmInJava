package xyz.bugcoder.interview;

import java.util.*;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.interview
 * @Description:
 * @Date: 2019-10-17 17:16
 * @Author: Wyj
 */
public class Count5WordsFromText{

    public static void count(String[] allWords){
        List<String> words = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> values = new ArrayList<>();
        // 先将所有单词添加到List中
        for (String s : allWords) {
            words.add(s);
        }
        for (String s : words) {
            if (words.contains(s)){
                // 不判断空，会导致空指针异常
                if (map.get(s) == null){
                    map.put(s, 1);
                }
                else {
                    map.put(s, map.get(s) + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            values.add(e.getValue());
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public static void main(String[] args) {
        String text = "Our diurnal existence is divided into two phases, " +
                "as distinct as day and night. We call them work and play. " +
                "We work so many hours a day. And, when we have allowed the " +
                "necessary minimum for such activities as eating and shopping, " +
                "the rest we spend in various activities which are known as " +
                "recreations, an elegant word which disguises the fact that " +
                "we usually do not even play in our hours of leisure, but " +
                "spend them in various forms of passive enjoyment or " +
                "entertainment―not playing football but watching football " +
                "matches；not acting but theatre-going；Not walking but riding " +
                "in a motor coach.";
        String[] allWords = text.split(" ");
        count(allWords);
    }
}
