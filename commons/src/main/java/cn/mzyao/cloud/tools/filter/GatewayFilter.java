package cn.mzyao.cloud.tools.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.mzyao.cloud.tools.enums.ResponseCode;
import cn.mzyao.cloud.tools.exception.GatewayException;
import cn.mzyao.cloud.tools.result.Result;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截请求，鉴别非法请求
 * 防止外部请求直接绕过 gateway 网关直接请求接口
 */
@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "gatewayFilter")
public class GatewayFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Api02 GatewayFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String gateway = request.getHeader("gatewayKey");
        if (StrUtil.isEmpty(gateway) || !gateway.equals("key")) {
            log.error("非法请求");
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().write(JSONUtil.toJsonStr(Result.fail(ResponseCode.ILLEGALITY_ERROR)));
            return;
        }
        filterChain.doFilter(request, response);
    }
}
