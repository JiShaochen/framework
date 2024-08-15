package com.morning.framework.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
      
    @Override  
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MineInterceptor())
                .addPathPatterns("/**") // 拦截所有路径  
                .excludePathPatterns("/static/**"); // 排除静态资源路径  
    }  
}