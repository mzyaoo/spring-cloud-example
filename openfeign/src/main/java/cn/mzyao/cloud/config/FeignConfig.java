package cn.mzyao.cloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    /**
     * 请求转发统一增加请求头
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // 添加自定义的请求头
                template.header("gatewayKey", "key");
            }
        };
    }

}
