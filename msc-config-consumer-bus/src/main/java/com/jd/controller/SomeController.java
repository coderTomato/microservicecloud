package com.jd.controller;

import com.jd.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/consumer/depart")
public class SomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${prefix}")
    private String prefix;

    //直连提供者
    //private static final String SERVICE_PROVIDER = "http://localhost:8081";
    //要使用微服务名称来从eureka server查找提供者
    private static final String SERVICE_PROVIDER = "http://msc-provider";


    @PostMapping("/save")
    public boolean saveHandler(@RequestBody Depart depart){
        depart.setName(prefix+depart.getName());
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

    @GetMapping("/get/{id}")
    public Depart getByIdHandler(@PathVariable("id") int id){
        String url = SERVICE_PROVIDER + "/provider/depart/get/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandler(){
        String url = SERVICE_PROVIDER + "/provider/depart/list";
        return restTemplate.getForObject(url, List.class);
    }
}
