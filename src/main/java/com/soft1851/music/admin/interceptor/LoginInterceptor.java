package com.soft1851.music.admin.interceptor;

import com.soft1851.music.admin.handler.RequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description 登录拦截器
 * 可以做下参数校验、验证码有效性等
 * @Author mq_xu
 * @Date 2020/4/15
 * @Version 1.0
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
//    @Resource
//    private RedisService redisService;

    /**
     * 前置处理，拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            RequestWrapper requestWrapper = new RequestWrapper(request);
            String body = requestWrapper.getBody();
            log.info(body);
            //，，。
            return true;
        } catch (Exception e) {
            log.error("断出错", e);
        }
        return false;
    }
}
