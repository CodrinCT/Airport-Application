package com.example.AirportApp.Controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
//@Component
public class AuthorizationFilter implements Filter {

    @Override
   // @Bean
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest)request).getRequestURI();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse)response;
//        if(req.getServletPath().equals("/flightslist") && req.getSession(true).getAttribute("logged_user") != null){
//            chain.doFilter(request,response);
//        }
         if (!req.getServletPath().equals("/home")
                && req.getSession(true).getAttribute("logged_user") == null){
            ((HttpServletResponse) response).sendRedirect("/home");

//            if ( uri.indexOf("/css") > 0){
//                chain.doFilter(request, response);
//            }
//            else if( uri.indexOf("/images") > 0){
//                chain.doFilter(request, response);
//            }
//            else if( uri.indexOf("/js") > 0){
//                chain.doFilter(request, response);
//            }
        }
        else{
            chain.doFilter(request, response);
        }
//
//        if ( uri.contains("/css")){
//            chain.doFilter(request, response);
//        }
//        if( uri.contains("/images")){
//            chain.doFilter(request, response);
//        }
//        if( uri.contains("/js")){
//            chain.doFilter(request, response);
//        }
    }

    @Override
   // @Bean
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
   // @Bean
    public void destroy() {
    }
}
