package com.austin.filter;


import com.alibaba.fastjson.JSONObject;
import com.austin.pojo.Result;
import com.austin.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取响应对象
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取请求url
        String requestURl = request.getRequestURL().toString();
        log.info("requestURl = {}", requestURl);

        //判断是否是login
        if (requestURl.contains("/login")){
            filterChain.doFilter(request, response);
            return;
        }

        //获取请求令牌
        String token=request.getHeader("token");

        //令牌不存在，未登录
        if (token==null){
            log.info("token is null");
            Result responseResult = Result.error("NOT_LOGIN");
            //转换为json串
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf8");

            //响应
            response.getWriter().write(json);
            return;
        }

        //解析jwt
        try {
            JwtUtils.parseJWT(token);
        }catch (Exception exception) {
            log.info("fail to check token");
            Result responseResult = Result.error("NOT_LOGIN");
            //转换为json串
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf8");

            //响应
            response.getWriter().write(json);
            return;
        }
        filterChain.doFilter(request, response);
        log.info("success to login...");
    }

}
