/**
 * 
 */
package cn.blaze.vo;

import cn.blaze.consts.RetCode;

import java.io.Serializable;

/**
 * ajax请求返回结果封装
 */
public class AjaxResult implements Serializable {

    private static final long serialVersionUID = 8051918669445394580L;

    private int code = RetCode.SUCCESS.code;

    private String msg = null;

    private Object content = null;

    public AjaxResult(int code) {
        this.code = code;
        RetCode rc = RetCode.valueOf(code);
        if (rc != null)
            this.msg = rc.msg;
    }

    public AjaxResult(int code, Object content) {
        this(code);
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
