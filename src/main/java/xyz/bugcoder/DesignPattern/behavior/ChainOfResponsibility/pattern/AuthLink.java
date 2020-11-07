package xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal.AuthInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.pattern
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 15:46
 */

// 好处：遵循了单一职责和开闭原则，简单耦合也使对象关系更加清晰，⽽且外部的调⽤ ⽅并不需要关⼼责任链是如何进⾏处理的

@Data
public abstract class AuthLink {

    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间格式化

    protected Logger logger = LoggerFactory.getLogger(AuthLink.class);

    // 标记每⼀个审核节点的⼈员信息
    protected String levelUserId;
    protected String levelUserName;
    private AuthLink next;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    // 这部分是责任链，链接起来的核⼼部分。 AuthLink next ，重点在于可以通过 next ⽅式获取下 ⼀个链路需要处理的节点。
    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    // 每⼀个实现者必须实现的 类，不同的审核级别处理不同的业务。
    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
