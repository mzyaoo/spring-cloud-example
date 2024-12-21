package cn.mzyao.cloud.handler;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@Slf4j
@Order(-1)
@Component
public class GatewayExceptionHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable throwable) {
        ServerHttpResponse response = exchange.getResponse();
        if (response.isCommitted()) {
            return Mono.error(throwable);
        }
        JSONObject resultObj = JSONUtil.createObj();
        if (throwable instanceof ResponseStatusException){
            resultObj.set("errorCode","40400");
            resultObj.set("errorMsg","资源未找到");
        }else{
            resultObj.set("errorCode","50000");
            resultObj.set("errorMsg","网关错误，请联系管理员！");
        }

        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        writeLog(exchange, throwable);

        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            return bufferFactory.wrap(resultObj.toString().getBytes());
        }));
    }

    /**
     * 记录异常日志
     * @param exchange
     * @param throwable
     */
    private void writeLog(ServerWebExchange exchange, Throwable throwable) {
        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        String host = uri.getHost();
        int port = uri.getPort();
        log.error("[gateway]-host:{} ,port:{}，url:{},  errormessage:", host, port, request.getPath(), throwable);
    }

}
