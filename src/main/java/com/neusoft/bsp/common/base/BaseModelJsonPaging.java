package com.neusoft.bsp.common.base;

public class BaseModelJsonPaging<T> extends BaseModel {

    public T data;
    public Integer total;

    @Override
    public String toString() {
        return "BaseModelJsonPaging{" +
                "data=" + data +
                ", total=" + total +
                '}';
    }
}
