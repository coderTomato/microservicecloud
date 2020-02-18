package com.jd;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy //开启zuul代理模式
@SpringBootApplication
public class MscfilterZuul9000Application {

	public static void main(String[] args) {
		SpringApplication.run(MscfilterZuul9000Application.class, args);
	}

}
