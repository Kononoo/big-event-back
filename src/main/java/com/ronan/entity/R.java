package com.ronan.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: R
 * Package: com.ronan.entity
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 14:56
 * @Version: v1.0
 */
@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;           // 1 表示成功  0 表示失败
    private String message;        // 响应信息
    private T data;                 // 返回数据

    /**
     * 返回成功数据
     * @param data
     * @return
     * @param <T>
     */
    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setCode(1);
        r.setMessage("OK");
        r.setData(data);
        return r;
    }

    public static R success() {
        R<Object> r= new R<>();
        r.setCode(0);
        r.setMessage("操作成功");
        return r;
    }

    /**
     * 返回错误信息
     * @param msg
     * @return
     * @param <T>
     */
    public static <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.setCode(0);
        r.setMessage(msg);
        return r;
    }
}
