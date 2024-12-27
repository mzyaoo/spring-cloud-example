package cn.mzyao.cloud.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Decoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    /**
     * 请求拦截器
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


//    @Bean
//    public Decoder feignDecoder(ObjectProvider<HttpMessageConverters> messageConverters) {
//        return new OptionalDecoder((new ResponseEntityDecoder(new ResponseDecoder(new SpringDecoder(messageConverters)))));
//    }

    @Bean
    public Decoder feignDecoder() {
        return new ResponseDecoder();
    }


}
