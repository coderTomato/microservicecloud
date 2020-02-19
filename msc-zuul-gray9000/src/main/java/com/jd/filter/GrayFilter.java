package com.jd.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lijun
 * @create 2020-02-19 12:12
 */
//@Component
public class GrayFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        //所有请求都通过zuul过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("通过zuul过滤了");
        //获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        //获取请求
        HttpServletRequest request = context.getRequest();
        //获取指定的请求头信息，该头信息在浏览器提交请求时携带，用于区分该请求被路由到哪个主机处理
        String mark = request.getHeader("gray-mark");
        //默认将请求路由到running-host上
        RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
        //若mark的值不为空且值为enable，则将请求路由到gray-host，其它请求路由到默认的running-host
        if(!StringUtils.isEmpty(mark) && "enable".equals(mark)){
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
        }
        return null;
    }
}
