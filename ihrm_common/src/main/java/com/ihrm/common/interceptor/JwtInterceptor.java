package com.ihrm.common.interceptor;

import com.ihrm.common.entity.ResultCode;
import com.ihrm.common.exception.CommonException;
import com.ihrm.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/18 14:10
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")) {
            String token = authorization.replace("Bearer ", "");
            Claims claims = jwtUtils.parseJwt(token);
            if (claims != null) {
                String apis = String.valueOf(claims.get("apis"));
                HandlerMethod method = (HandlerMethod) handler;
                RequestMapping mapping = method.getMethodAnnotation(RequestMapping.class);
                String name = mapping.name();
                if (apis.contains(name)) {
                    request.setAttribute("user_claims", claims);
                    return true;
                }
            }
        }
        throw new CommonException(ResultCode.UNAUTHENTICATED);
    }
}
