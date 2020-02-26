package com.scrapy.helloscrapy.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping(value ="/class/")
public class ClassInfo {
    private ApplicationContext appContext;

    @RequestMapping(value = "beans",method = RequestMethod.POST)
    public void getBeans(HttpServletRequest request) throws Exception
    {
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans)
        {
            System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
        }
    }
}
