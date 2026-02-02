package com.darkross.adminsecurityservice.util;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class TraceFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String requestId = req.getHeader("X-Request-Id");
        if (requestId == null) {
            requestId = UUID.randomUUID().toString();
        }

        String ip = resolveClientIp(req);
        String app = req.getHeader("X-Application-Id");

        // MDC = contexto del hilo
        MDC.put("requestId", requestId);
        MDC.put("ip", ip);
        MDC.put("app", app != null ? app : "unknown");

        log.info("➡️ Request START {} {}", req.getMethod(), req.getRequestURI());

        try {
            chain.doFilter(request, response);
        } finally {
            log.info("⬅️ Request END {} {}", req.getMethod(), req.getRequestURI());
            MDC.clear(); // CRÍTICO
        }
    }

    private String resolveClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !ip.isBlank()) {
            return ip.split(",")[0].trim();
        }

        ip = request.getRemoteAddr();
        if ("::1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            return "127.0.0.1";
        }
        return ip;
    }
}