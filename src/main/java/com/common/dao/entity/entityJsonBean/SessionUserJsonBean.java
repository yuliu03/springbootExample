package com.common.dao.entity.entityJsonBean;

import java.util.HashMap;

public class SessionUserJsonBean {
    private String token;
    private long sessionTime;
    private HashMap<String,Object> info;

    public SessionUserJsonBean(){};
    public SessionUserJsonBean(String token, long sessionTime, HashMap<String, Object> info) {
        this.token = token;
        this.sessionTime = sessionTime;
        this.info = info;
    }

    public long getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(long sessionTime) {
        this.sessionTime = sessionTime;
    }

    public HashMap<String, Object> getInfo() {
        return info;
    }

    public void setInfo(HashMap<String, Object> info) {
        this.info = info;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void put(String key, Object value){
        info.put(key,value);
    }

    public Object get(String key){
        return info.get(key);
    }
}
