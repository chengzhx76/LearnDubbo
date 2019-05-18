package com.github.chengzhx76.spring.schema;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Desc:
 * Author: 光灿
 * Date: 2019/5/18
 */
public class SimpleBeanDefintionParser implements BeanDefinitionParser {

    private Class<?> beanClass;

    public SimpleBeanDefintionParser(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        System.out.println("SimpleBeanDefintionParser.parse===========>");

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);

        String name = element.getAttribute("name");
        int age = element.getAttribute("age") != null ? Integer.parseInt(element.getAttribute("age")) : -1;
        int sex = element.getAttribute("sex") != null ? Integer.parseInt(element.getAttribute("age")) : 1;
        parserContext.getRegistry().registerBeanDefinition(name, beanDefinition);
        beanDefinition.getPropertyValues().addPropertyValue("name", name);
        beanDefinition.getPropertyValues().addPropertyValue("age", age);
        beanDefinition.getPropertyValues().addPropertyValue("sex", sex);
        return beanDefinition;
    }
}
