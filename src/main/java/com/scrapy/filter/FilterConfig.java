package com.scrapy.filter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        MyFilter myFilter=new MyFilter();
        filterRegistrationBean.setFilter(myFilter);
        List<String> urls=new ArrayList<String>();
        urls.add("/*");                     //过滤所有请求
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }
}
