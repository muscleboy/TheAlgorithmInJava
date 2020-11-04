package xyz.bugcoder.DesignPattern.structure.flyweight;

import lombok.Data;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.flyweight
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-04 16:54
 */
@Data
public class Stock {

    private int total; // 库存总量
    private int used;  // 库存已用

    public Stock(int total, int used) {
        this.total = total;
        this.used = used;
    }
}
