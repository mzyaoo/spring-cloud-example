package cn.mzyao.cloud.config;

import cn.hutool.json.JSONUtil;
import cn.mzyao.cloud.tools.result.Result;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class ResponseDecoder implements Decoder {

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        if (response.body() == null) {
            throw new DecodeException(response.status(), "没有返回有效的数据", response.request());
        }
        String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
        System.out.println(bodyStr);
        if (type instanceof Result){
            return JSONUtil.toBean(bodyStr, Result.class);
        }
//        Result<?> result = JSONUtil.toBean(bodyStr, Result.class);

        return response.body();
    }
}
