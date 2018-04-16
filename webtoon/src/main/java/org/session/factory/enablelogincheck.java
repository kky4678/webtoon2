package org.session.factory;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.support.domain.Member;

public class enablelogincheck extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        Member m = (Member) session.getAttribute("m");
         
        if ( m != null ){
        	response.setCharacterEncoding("UTF-8");
        	response.setContentType("text/html; charset=UTF-8");
        	PrintWriter writer = response.getWriter();
        	writer.println("<script>alert('이미 로그인이 되어 있습니다.'); window.location.href='/toon';</script>");
            return false;
        }
        return true;
    }
}
