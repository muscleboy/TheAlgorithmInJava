package xyz.bugcoder.DesignPattern.structure.status;

import lombok.Data;

/**
 * @Package: xyz.bugcoder.DesignPattern.structure.status
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-10 15:26
 */
@Data
public class Result {

    private String code; // 编码
    private String info; // 描述

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }

}
