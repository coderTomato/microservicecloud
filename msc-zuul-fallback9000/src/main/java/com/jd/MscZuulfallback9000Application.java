package com.jd;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy //开启zuul代理模式
@SpringBootApplication
public class MscZuulfallback9000Application {

	public static void main(String[] args) {
		SpringApplication.run(MscZuulfallback9000Application.class, args);
	}

	//设置负载均衡算法为"随机算法"
	@Bean
	public IRule loadBalanceRule(){
		return new RandomRule();
	}
}
