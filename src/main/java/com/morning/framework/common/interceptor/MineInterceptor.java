package com.morning.framework.common.interceptor;

import com.alibaba.fastjson2.JSON;
import com.morning.framework.common.anno.NotRequired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * @author MorningJs
 * @date 2024/6/13 16:46
 * @desc
 */
@Slf4j
public class MineInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            String token = request.getHeader("token");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            log.info("请求url: {}", request.getRequestURL());
            log.info("请求方式：{}", request.getMethod().toUpperCase());
            Class<?> controllerClass = handlerMethod.getBeanType();
            String methodName = handlerMethod.getMethod().getName();
            Map<String, String[]> parameterMap = request.getParameterMap();
            log.info("请求参数: {}", Objects.nonNull(parameterMap) ? JSON.toJSONString(parameterMap): "");
            log.info("请求类: {}", controllerClass.getName());
            log.info("请求方法: {}", methodName);
            NotRequired annotation = handlerMethod.getMethodAnnotation(NotRequired.class);
            if (!StringUtils.isEmpty(token) || Objects.nonNull(annotation)) {
                return true;
            }
            throw new Exception("没有token");
        }
        return true;
    }

}