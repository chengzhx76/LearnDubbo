package com.cheng.dubbo.consumer.test;

import com.cheng.dubbo.People;
import com.cheng.dubbo.SpeakInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Desc: 消费者
 * Author: Cheng
 * Date: 2016/2/19 0019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-dubbo-consumer.xml",
        "classpath*:applicationContext.xml"})
public class BaseTest {
    @Resource
    private SpeakInterface speakInterface;
    @Test
    public void test() {
        People people = new People();
        people.setAge(18);
        people.setSex(0);
        System.out.println(speakInterface.speak(people));
    }

}
