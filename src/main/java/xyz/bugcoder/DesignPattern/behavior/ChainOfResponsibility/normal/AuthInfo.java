package xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal;

import lombok.Data;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.ChainOfResponsibility.normal
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-07 15:16
 */

@Data
public class AuthInfo {

    private String code;
    private String info = "";

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String s : infos) {
            this.info = this.info.concat(s);
        }
    }
}
