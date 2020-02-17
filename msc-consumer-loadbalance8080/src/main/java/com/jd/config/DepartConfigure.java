package com.jd.config;

import com.jd.balance.CustomRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DepartConfigure {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //指定Ribbon使用随机策略
    @Bean
    public IRule loadBalanceRule(){
        //return new RandomRule();
        List<Integer> ports = new ArrayList<>();
        ports.add(8081);
        return new CustomRule(ports);
    }
}
