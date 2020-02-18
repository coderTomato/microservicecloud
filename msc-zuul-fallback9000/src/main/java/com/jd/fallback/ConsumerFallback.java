package com.jd.fallback;


import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ConsumerFallback implements FallbackProvider {

    //指定要降级的微服务名称
    @Override
    public String getRoute() {
        //仅对指定的微服务进行降级
        //return "msc-consumer-8080";
        //对所有微服务降级
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        //若微服务不是msc-consumer-8080，则不进行降级
        if(!"msc-consumer-8080".equals(route)){
            return null;
        }
        //仅对msc-consumer-8080进行降级
        return new ClientHttpResponse(){

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                //设置降级信息
                String msg = "fallback:" + route;
                return new ByteArrayInputStream(msg.getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                //返回状态常量
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                //返回状态码
                return HttpStatus.SERVICE_UNAVAILABLE.value();
            }

            @Override
            public String getStatusText() throws IOException {
                //返回状态码对应的状态短语
                return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }
}
