package xyz.bugcoder.DesignPattern.create.prototype.pattern;

import lombok.Data;

import java.util.Map;

/**
 * @Package: xyz.bugcoder.DesignPattern.create.prototype.pattern
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-10-31 15:18
 */
@Data
public class Topic {

    // 选项；A、B、C、D
    private Map<String, String> option;
    // 答案；B
    private String key;

    public Topic(Map<String, String> option, String key) {
        this.option = option;
        this.key = key;
    }
}
