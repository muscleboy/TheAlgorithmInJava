package xyz.bugcoder.DesignPattern.create.prototype.normal;

import lombok.Data;

import java.util.Map;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.prototype
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 14:51
 */

@Data
public class ChoiceQuestion {

    // 题目
    private String name;
    // 选项ABCD
    private Map<String, String> option;
    // 答案
    private String key;

    public ChoiceQuestion(String name, Map<String, String> option, String key) {
        this.name = name;
        this.option = option;
        this.key = key;
    }
}
