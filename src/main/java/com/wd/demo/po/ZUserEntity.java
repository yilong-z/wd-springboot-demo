package com.wd.demo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ZUser", schema = "zyl_oa", catalog = "")
public class ZUserEntity {


    private int zuId;
    private String loginName;
    private String password;
    private String username;
    private String phone;
    private String email;
    private String genTime;
    private String loginTime;
    private String lastLoginTime;
    private int count;


    public int getZuId() {
        return zuId;
    }

    public void setZuId(int zuId) {
        this.zuId = zuId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenTime() {
        return genTime;
    }

    public void setGenTime(String genTime) {
        this.genTime = genTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZUserEntity that = (ZUserEntity) o;
        return zuId == that.zuId &&
                count == that.count &&
                Objects.equals(loginName, that.loginName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(username, that.username) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(genTime, that.genTime) &&
                Objects.equals(loginTime, that.loginTime) &&
                Objects.equals(lastLoginTime, that.lastLoginTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zuId, loginName, password, username, phone, email, genTime, loginTime, lastLoginTime, count);
    }

    @Override
    public String toString() {
        return "ZUserEntity{" +
                "zuId=" + zuId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", genTime=" + genTime +
                ", loginTime=" + loginTime +
                ", lastLoginTime=" + lastLoginTime +
                ", count=" + count +
                '}';
    }
}
