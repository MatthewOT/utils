package com.myutils.utils.fillter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: utils
 * @description: ip过滤
 * @author:
 * @create: 2019-10-15 12:32
 **/


/*
定义spring IOC容器中，bean执行的优先级，由于该fillter作为IP过滤使用，所以将优先级设置最高。
@Order注解中，value默认值为2147483647，优先级最低。值越大优先级越低，值的范围在-2147483647和2147483647之间
  */
@Order(value = 1)
@WebFilter(urlPatterns = {"/指定需要fillter的url","/ipFillterDemo"})
public class ipFillter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ipFillter.class);
    private static final String UNKNOWN = "unknown";
    //允许通过的ip
    //private static final List<String> PASS_IP = Arrays.asList("允许的ip地址1","ip2","ip3");//我的垃圾代码


    //大佬的代码
    private static final List<String> PASS_IP = Stream.of("ip1","ip2","ip3").collect(Collectors.toList());
    //问题1：为什么这么写？跟asList有啥区别？优点在哪？


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (logger.isInfoEnabled()){
            logger.info("ipFilter is initalized--------");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //获取真实ip
        String realIp = getRealIp((HttpServletRequest)request);
        //若ip为空，或不在passList内，则返回未授权
        //我的垃圾
//        if (realIp.isEmpty()||(!PASS_IP.contains(realIp))){
//            returnNoPermissionMsg((HttpServletResponse) response);

        //大佬的
        if (Objects.isNull(realIp)||(PASS_IP.stream().noneMatch(realIp::startsWith))){

            //问题2：lambda表达式以及使用stream（）的优点在哪？

                returnNoPermissionMsg((HttpServletResponse) response);
        }else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        if (logger.isInfoEnabled()){
            logger.info("ipFilter is destoryed--------");
        }
    }

    /**
     * 返回不可访问的msg
     * @param response
     */
    private void returnNoPermissionMsg(HttpServletResponse response) throws IOException {
        response.setContentType("UTF-8");
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("{\"code\":401}");
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 通过层层代理获取本次请求真实ip
     * @param request
     * @return
     */
    private String getRealIp(HttpServletRequest request) {
        String realIP;
        String ipAddresses = request.getHeader("X-Forwarded-For");

        //问题3：如果是我，判断为空时，可能会使用比较初级的.equals()或是==，
        // 而不是Objects.isNull()，这两者之间有什么区别

        // apache 服务代理
        if (Objects.isNull(ipAddresses) || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        // weblogic 服务代理
        if (Objects.isNull(ipAddresses) || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        // 某些代理服务器
        if (Objects.isNull(ipAddresses) || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        // nginx服务代理
        if (Objects.isNull(ipAddresses) || UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("X-Real-IP");
        }
        // 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号(,)分割开来，并且第一个ip为客户端的真实IP
        if (!Objects.isNull(ipAddresses) && !UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            realIP = ipAddresses.split(",")[0];
        } else {
            //还是不能获取到，最后再通过request.getRemoteAddr();获取
            realIP = request.getRemoteAddr();
        }
        return realIP;
    }
}
