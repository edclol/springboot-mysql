package com.qfanfeng.entry;

/**
 * 流量实体
 */
public class FlowStatsKV {
    public String key;  //泛指key
    public String value; //对应的值

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
