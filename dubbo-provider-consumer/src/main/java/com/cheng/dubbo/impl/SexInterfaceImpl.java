package com.cheng.dubbo.impl;

import com.cheng.dubbo.GrowUpInterface;
import com.cheng.dubbo.People;
import com.cheng.dubbo.SexInterface;

import javax.annotation.Resource;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/2/26 0026
 */
//@Component("sexInterface")
public class SexInterfaceImpl implements SexInterface {

    @Resource
    private GrowUpInterface growUpInterface;

    @Override
    public People sex(People people) {
        people = growUpInterface.addAge(people);
        people.setAge(99);
        return people;
    }
}
