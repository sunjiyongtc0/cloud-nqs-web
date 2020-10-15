package com.acsno.ext.kit;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Ret extends HashMap {

    private static final String STATE = "state";
    private static final String STATE_OK = "ok";
    private static final String STATE_FAIL = "fail";

    public Ret() {
    }

    public static Ret by(Object key, Object value) {
        return new Ret().set(key, value);
    }

    public static Ret create(Object key, Object value) {
        return new Ret().set(key, value);
    }

    public static Ret create() {
        return new Ret();
    }

    public static Ret ok() {
        return new Ret().setOk();
    }

    public static Ret ok(Object key, Object value) {
        return ok().set(key, value);
    }

    public static Ret fail() {
        return new Ret().setFail();
    }

    public static Ret fail(Object key, Object value) {
        return fail().set(key, value);
    }

    public Ret setOk() {
        super.put(STATE, STATE_OK);
        return this;
    }

    public Ret setFail() {
        super.put(STATE, STATE_FAIL);
        return this;
    }

    public boolean isOk() {
        Object state = get(STATE);
        if (STATE_OK.equals(state)) {
            return true;
        }
        if (STATE_FAIL.equals(state)) {
            return false;
        }

        throw new IllegalStateException("调用 isOk() 之前，必须先调用 ok()、fail() 或者 setOk()、setFail() 方法");
    }

    public boolean isFail() {
        Object state = get(STATE);
        if (STATE_FAIL.equals(state)) {
            return true;
        }
        if (STATE_OK.equals(state)) {
            return false;
        }

        throw new IllegalStateException("调用 isFail() 之前，必须先调用 ok()、fail() 或者 setOk()、setFail() 方法");
    }

    public Ret set(Object key, Object value) {
        super.put(key, value);
        return this;
    }

    public Ret setIfNotBlank(Object key, String value) {
        if (StrUtil.isNotBlank(value)) {
            set(key, value);
        }
        return this;
    }

    public Ret setIfNotNull(Object key, Object value) {
        if (value != null) {
            set(key, value);
        }
        return this;
    }

    public Ret set(Map map) {
        super.putAll(map);
        return this;
    }

    public Ret set(Ret ret) {
        super.putAll(ret);
        return this;
    }

    public Ret delete(Object key) {
        super.remove(key);
        return this;
    }

    public <T> T getAs(Object key) {
        return (T)get(key);
    }

    public String getStr(Object key) {
        Object s = get(key);
        return s != null ? s.toString() : null;
    }

    public Integer getInt(Object key) {
        Number n = (Number)get(key);
        return n != null ? n.intValue() : null;
    }

    public Long getLong(Object key) {
        Number n = (Number)get(key);
        return n != null ? n.longValue() : null;
    }

    public Double getDouble(Object key) {
        Number n = (Number)get(key);
        return n != null ? n.doubleValue() : null;
    }

    public Float getFloat(Object key) {
        Number n = (Number)get(key);
        return n != null ? n.floatValue() : null;
    }

    public Number getNumber(Object key) {
        return (Number)get(key);
    }

    public Boolean getBoolean(Object key) {
        return (Boolean)get(key);
    }

    /**
     * key 存在，并且 value 不为 null
     */
    public boolean notNull(Object key) {
        return get(key) != null;
    }

    /**
     * key 不存在，或者 key 存在但 value 为null
     */
    public boolean isNull(Object key) {
        return get(key) == null;
    }

    /**
     * key 存在，并且 value 为 true，则返回 true
     */
    public boolean isTrue(Object key) {
        Object value = get(key);
        return (value instanceof Boolean && ((Boolean)value == true));
    }

    /**
     * key 存在，并且 value 为 false，则返回 true
     */
    public boolean isFalse(Object key) {
        Object value = get(key);
        return (value instanceof Boolean && ((Boolean)value == false));
    }

    public String toJson() {
//        return Json.getJson().toJson(this);
        return JSON.toJSON(this).toString();
    }

    public boolean equals(Object ret) {
        return ret instanceof Ret && super.equals(ret);
    }
}