package org.example.advice;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.ResponseResult;
import org.example.exception.BizException;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @author jingwen.li
 * @date 2022/2/28
 *
 * 对返回结果统一处理
 *
 */
@Slf4j
@RestControllerAdvice(basePackages = "org.example")
public class ResponseHandlerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果body为空，返回默认信息
        ResponseResult<?> result = ResponseResult.success(o);
        result.setPath(serverHttpRequest.getURI().getPath());
        if (o == null) {
            return ResponseResult.success(null);
        }
        if (o instanceof BizException){
            removeMDC();
            return ResponseResult.error(((BizException) o).getErrorCode(), ((BizException) o).getErrorMsg());
        }
        //匹配ResponseResult
        if (o instanceof ResponseResult) {
            removeMDC();
            return o;
        }
        /**
         * 其他情况直接将返回的信息直接塞在data中
         */
        return result;

    }

    private void removeMDC(){
        String uuid = MDC.get("traceId");
        log.info("remove requestId ({}) from logger", uuid);
        MDC.remove("traceId");
    }
}
