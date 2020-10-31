package xyz.bugcoder.DesignPattern.create.prototype.normal;

import lombok.Data;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.prototype
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 14:50
 */

@Data
public class AnswerQuestion {
    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }

    // 问题
    private String name;
    // 答案
    private String key;

}
