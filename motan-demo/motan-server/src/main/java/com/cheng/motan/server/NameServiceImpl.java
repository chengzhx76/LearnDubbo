package com.cheng.motan.server;

import com.cheng.motan.api.NameService;
import com.cheng.motan.api.People;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/2/26 0026
 */
public class NameServiceImpl implements NameService {
    @Override
    public String getName(People people) {
        return "motan return "+people.getName();
    }
}
