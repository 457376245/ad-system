package com.jh.common.advice;

import com.jh.common.annotation.IgnoreResponseAdvice;
import com.jh.common.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
@Slf4j
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //当类或方法被@IgnoreResponseAdvice标记则返回false   不处理响应
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) return false;
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) return false;
        System.out.println("----------------------CommonResponseDataAdvice.supports is true----------------");
        log.info("----------------------CommonResponseDataAdvice.supports is true----------------");

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        CommonResponse<Object> response = new CommonResponse<>(0, "");
        if (o==null)return response;
        else if (o instanceof CommonResponse) return o;
        else {
            response.setData(o);
            return response;
        }
    }
}
