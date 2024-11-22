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
        //��ȡ�������
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //��ȡ��Ӧ����
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //��ȡ����url
        String requestURl = request.getRequestURL().toString();
        log.info("requestURl = {}", requestURl);

        //�ж��Ƿ���login
        if (requestURl.contains("/login")){
            filterChain.doFilter(request, response);
            return;
        }

        //��ȡ��������
        String token=request.getHeader("token");

        //���Ʋ����ڣ�δ��¼
        if (token==null){
            log.info("token is null");
            Result responseResult = Result.error("NOT_LOGIN");
            //ת��Ϊjson��
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf8");

            //��Ӧ
            response.getWriter().write(json);
            return;
        }

        //����jwt
        try {
            JwtUtils.parseJWT(token);
        }catch (Exception exception) {
            log.info("fail to check token");
            Result responseResult = Result.error("NOT_LOGIN");
            //ת��Ϊjson��
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf8");

            //��Ӧ
            response.getWriter().write(json);
            return;
        }
        filterChain.doFilter(request, response);
        log.info("success to login...");
    }

}
