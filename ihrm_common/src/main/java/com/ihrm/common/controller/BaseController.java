package com.ihrm.common.controller;

import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/17 10:22
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String companyId;
    protected String companyName;
    protected Claims claims;
    @ModelAttribute
    public void model(HttpServletRequest request ,HttpServletResponse response){
        this.request=request;
        this.response=response;

        Object obj=request.getAttribute("user_claims");
        if (obj != null) {
            this.claims=(Claims) obj;
            this.companyId=(String) claims.get("companyId");
            this.companyName=(String) claims.get("companyName");
        }
    }
}
