package com.jd.service;

import com.jd.bean.Depart;
import com.jd.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository repository;


    @Override
    public boolean saveDepart(Depart depart) {
        Depart obj = repository.save(depart);
        return obj != null? true : false;
    }

    @Override
    public boolean removeDepartById(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = repository.save(depart);
        return obj != null? true : false;
    }

    @Override
    public Depart getDepartById(int id) {
        int time = id;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(repository.existsById(id)){
            return repository.getOne(id);
        }
        Depart depart = new Depart();
        depart.setName("no this depart");
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {

        return repository.findAll();
    }
}
