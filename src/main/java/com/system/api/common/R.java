package com.system.api.common;


import lombok.Data;

@Data
public class R {


    private Integer code;

    private String msg;

    private Object data;


    public static R ok(Object data) {
        R r = new R();
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static R ok() {
        R r = new R();
        r.setCode(200);
        r.setData("");
        return r;
    }


    public static R fail(String msg) {
        R r = new R();
        r.setMsg(msg);
        r.setCode(100);
        return r;
    }
}
