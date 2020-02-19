package com.jd.controller;

import com.jd.bean.Depart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
public class SomeController {

    @Autowired
    private RestTemplate restTemplate;
    //直连提供者
    //private static final String SERVICE_PROVIDER = "http://localhost:8081";
    //要使用微服务名称来从eureka server查找提供者
    private static final String SERVICE_PROVIDER = "http://msc-provider";


    @PostMapping("/save")
    public boolean saveHandler(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER + "/provider/depart/save";
        return restTemplate.postForObject(url, depart,Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void delHandler(@PathVariable("id") int id){
        String url = SERVICE_PROVIDER + "/provider/depart/del/" + id;
        restTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandler(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER + "/provider/depart/update";
        restTemplate.put(url, depart);
    }

    //指定该方法要使用服务降级，即当前处理器方法在运行过程中若发生异常
    //无法给客户端正常响应时，就会调用fallbackmethod指定的方法
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getHystrixHandler",commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="4000"))
    public Depart getByIdHandler(@PathVariable("id") int id){
        String url = SERVICE_PROVIDER + "/provider/depart/get/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }

    //服务降级方法，响应给客户端的备选方案
    public Depart getHystrixHandler(@PathVariable("id") int id){
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart");
        return depart;
    }

    @GetMapping("/list")
    public List<Depart> listHandler(){
        String url = SERVICE_PROVIDER + "/provider/depart/list";
        return restTemplate.getForObject(url, List.class);
    }
}
