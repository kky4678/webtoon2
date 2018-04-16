package org.session.factory;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.support.domain.Member;

public class logincheck extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // session 객체를 가져옴
        HttpSession session = request.getSession();
        // login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
        Member m = (Member) session.getAttribute("m");
         
        if ( m == null ){
        	response.setCharacterEncoding("UTF-8");
        	response.setContentType("text/html; charset=UTF-8");
        	PrintWriter writer = response.getWriter();
        	writer.println("<script>alert('로그인 후 이용해주세요.'); location.href='/toon/member/login';</script>");
            return false;
        }
        return true;
    }
}
