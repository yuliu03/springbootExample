package com.scrapy.helloscrapy.interceptor;


import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSONObject;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.common.GlobalConfigParam;
import com.scrapy.helloscrapy.common.RedisUtil;
import com.scrapy.helloscrapy.common.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInteceptor  implements HandlerInterceptor{
    //无论controller中是否抛出异常，都会调用该方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex)
            throws Exception {
        System.out.println("afterCompletion");
        long start=new Date().getTime();
        System.out.println("最后耗时为:"+(new Date().getTime()-start));
        System.out.println("ex is"+ex);
    }
    //如果controller中抛出异常，则该方法不会被调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView view)
            throws Exception {
//      ModelMap map=new ModelMap();
//      map.addAttribute("name", "shinelon");
        System.out.println("postHandle");
        long start=(long) request.getAttribute("start");
        System.out.println("消耗的时间为:"+(new Date().getTime()-start));

    }
    //最先执行该方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        System.out.println("preHandle");
        request.setAttribute("start", new Date().getTime());
        System.out.println("开始时间:"+new Date().getTime());

        if (StringUtils.equalsIgnoreCase(request.getMethod(), "OPTIONS")) {
            return true;
        }

//        System.out.println(((HandlerMethod)obj).getBean().getClass().getName());
//        System.out.println(((HandlerMethod)obj).getMethod().getName());

        //System.out.println("拦截请求----------"+arg0.getServletPath());
        String token = request.getHeader("token");
        System.out.println("token"+token);
        //String token = (String)arg0.getSession().getAttribute("token");
        if(StringUtils.isEmpty(token)){
            response.setContentType("text/html; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(JSONObject.toJSONString(new APIResponse("1000",null,"token未检测到")));
            writer.close();
            response.flushBuffer();
            return false;
        }

        RedisUtil redisUtil = SpringUtils.getBean(RedisUtil.class);
        //权限路径拦截
        if(!redisUtil.hasKey(GlobalConfigParam.TOKEN+token)){
            response.setContentType("text/html; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(JSONObject.toJSONString(new APIResponse("1001",null,"token超时")));
            writer.close();
            response.flushBuffer();
            return false;
        }
        //把reids里面的数据放到请求的session里面
//        SessionUserJsonBean user = (SessionUserJsonBean)redisUtil.setAndReturn(token, new SessionUserJsonBean(token,null, GlobalConfigParam.SESSION_TIME,null));
//        request.getSession().setAttribute("user", user);
        return true;
    }
}
