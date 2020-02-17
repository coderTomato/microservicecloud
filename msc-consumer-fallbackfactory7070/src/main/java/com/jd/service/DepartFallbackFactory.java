package com.jd.service;

import com.jd.bean.Depart;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lijun
 * @create 2020-02-17 17:42
 */
@Component
public class DepartFallbackFactory implements FallbackFactory<DepartService>
{
    @Override
    public DepartService create(Throwable throwable) {
        return new DepartService() {
            @Override
            public boolean saveDepart(Depart depart) {
                System.out.println("执行saveDepart()服务降级处理方法");
                return false;
            }

            @Override
            public boolean removeDepartById(Integer id) {
                System.out.println("执行removeDepartById()服务降级处理方法");
                return false;
            }

            @Override
            public boolean modifyDepart(Depart depart) {
                System.out.println("执行modifyDepart()服务降级处理方法");
                return false;
            }

            @Override
            public Depart getDepartById(int id) {
                Depart depart = new Depart();
                depart.setId(id);
                depart.setName("no this depart -- class级别");
                return depart;
            }

            @Override
            public List<Depart> listAllDeparts() {
                System.out.println("执行listAllDeparts()服务降级处理方法");
                return null;
            }
        };
    }
}
