package com.jd.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author lijun
 * @create 2020-02-18 22:10
 */
@Component
public class RouterFilter extends ZuulFilter {
    //每秒产生2个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);

    //指定路由之前执行过滤
    @Override
    public String filterType() {
        //返回 pre
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //在系统最小值-3的前面执行
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        //获取当前的请求上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        //RATE_LIMITER.tryAcquire() 若可以立即获取到1个令牌，则返回true，否则返回false 不阻塞
        //RATE_LIMITER.tryAcquire(5,3, TimeUnit.SECONDS) 若3秒内获取5个令牌，则返回true,否则返回false，不阻塞
        //RATE_LIMITER.acquire() 获取1个令牌，若获取不到，则阻塞直到获取到
        if(!RATE_LIMITER.tryAcquire()){
            //指定当前请求未通过zuul过滤，默认为true
            context.setSendZuulResponse(false);
            //向客户端响应429，请求数量过多
            context.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
            return false;
        }
        //从请求上下文中获取当前请求信息
        HttpServletRequest request = context.getRequest();
        String user = request.getParameter("user");
        String uri = request.getRequestURI();
        if(uri.contains("/msc8080") && StringUtils.isEmpty(user)){
            //指定当前请求未通过zuul过滤
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return true;
    }

    //对请求通过过滤后的逻辑
    @Override
    public Object run() throws ZuulException {
        System.out.println("通过过滤");
        return null;
    }
}
