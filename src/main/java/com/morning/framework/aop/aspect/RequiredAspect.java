package com.morning.framework.aop.aspect;

import com.morning.framework.common.dto.ThreadLocalUser;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author MorningJs
 * @date 2024/6/13 16:55
 * @desc
 */
@Aspect
@Component
public class RequiredAspect {

/*    @Before("@annotation(com.morning.framework.common.anno.NotRequired)")
    public void beforeAdvice() throws Exception {
        if (StringUtils.isEmpty(ThreadLocalUser.getUser())) {
            throw new Exception("不行");
        }
    }*/
}