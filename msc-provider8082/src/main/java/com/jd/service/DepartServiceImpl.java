package com.jd.service;

import com.jd.bean.Depart;
import com.jd.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository repository;

    @Value("${server.port}")
    private int port;

    @Override
    public Depart getDepartById(int id) {
        if(repository.existsById(id)){
            Depart depart = repository.getOne(id);
            depart.setName(depart.getName()+port);
            return depart;
        }
        Depart depart = new Depart();
        depart.setName("no this depart"+port);
        return depart;
    }

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
    public List<Depart> listAllDeparts() {
        List<Depart> departs = repository.findAll();
        for (Depart depart : departs) {
            depart.setName(depart.getName()+port);
        }
        return departs;
    }
}
