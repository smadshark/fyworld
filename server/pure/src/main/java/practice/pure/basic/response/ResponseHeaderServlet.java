package practice.pure.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Content-Length", "6");

        response.setHeader("my-header", "hello");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);// 단위는 초
        response.setHeader("Set-Cookie", "HeaderCookie=OMG; Max-Age=600");

        response.sendRedirect("/basic/hello-form.html");

        response.getWriter().write("안녕하세요.");
    }
}
