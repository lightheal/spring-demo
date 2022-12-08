package com.himan.model.user;

import java.io.Serializable;

/**
 * 用户对象
 */
public class User implements Serializable {
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户编号
     */
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
