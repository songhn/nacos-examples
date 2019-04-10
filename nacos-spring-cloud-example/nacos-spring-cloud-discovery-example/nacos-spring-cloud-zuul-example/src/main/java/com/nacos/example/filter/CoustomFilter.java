package com.nacos.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class CoustomFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String userName = httpServletRequest.getParameter("name");
        if("root".equals(userName)){
            //会进行路由，也就是会调用api服务提供者
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);
        }else {
            //不需要进行路由，也就是不会调用api服务提供者
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            //返回内容给客户端
            requestContext.setResponseBody("{\"result\":\"auth not correct!\"}");
        }
        return null;
    }
}
