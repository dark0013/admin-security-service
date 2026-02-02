package com.darkross.adminsecurityservice.interceptor;

import com.darkross.adminsecurityservice.dto.AuditInfo;
import com.darkross.adminsecurityservice.util.RequestContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
public class AuditInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        String ip = request.getRemoteAddr();
        String application = request.getHeader("X-Application-Id");
        String requestId = request.getHeader("X-Request-Id");

        if (requestId == null) {
            requestId = UUID.randomUUID().toString();
        }

        AuditInfo audit = AuditInfo.builder()
                .ip(ip)
                .application(application)
                .requestId(requestId)
                .build();

        RequestContext.set(audit);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        RequestContext.clear();
    }
}