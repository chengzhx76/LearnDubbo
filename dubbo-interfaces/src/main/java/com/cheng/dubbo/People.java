package com.cheng.dubbo;

import java.io.Serializable;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/2/19 0019
 */
public class People implements Serializable {
    private String name;
    private Integer age;
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
