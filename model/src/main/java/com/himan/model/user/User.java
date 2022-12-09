package com.himan.model.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户对象
 */
// lombok getter/setter
@Data
// jpa entity
@Entity
// jpa table
@Table(name = "hm_user")
public class User implements Serializable {
    /**
     * 用户名称 不能重复
     */
    // jpa column
    @Id
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 手机号码
     */
    @Column(name = "cell_phone_no")
    private String cellPhoneNo;

    /**
     * 电话号码
     */
    @Column(name = "phone_no")
    private String phoneNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 证件类型
     */
    private String identityType;

    /**
     * 证件号码
     */
    private String identityNo;
}
