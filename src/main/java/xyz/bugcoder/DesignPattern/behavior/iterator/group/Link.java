package xyz.bugcoder.DesignPattern.behavior.iterator.group;

import lombok.Data;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.iterator.group
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-08 15:11
 */
// ⽤于描述结构树中的各个节点之间的关系链，也就是 A to B 、 B to C 、 B to D ，以此 描述出⼀套完整的树组织结构。
@Data
public class Link {

    private String fromId;  // 雇员ID
    private String toId;  // 雇员ID

    public Link(String fromId, String toId) {
        this.fromId = fromId;
        this.toId = toId;
    }
}
