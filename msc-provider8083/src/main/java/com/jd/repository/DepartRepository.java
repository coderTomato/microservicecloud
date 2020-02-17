package com.jd.repository;


import com.jd.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

//第一个泛型是当前Repository所操作对象的类型
//第二个泛型是当前Repository所操作对象的id类型
public interface DepartRepository extends JpaRepository<Depart,Integer> {


}
