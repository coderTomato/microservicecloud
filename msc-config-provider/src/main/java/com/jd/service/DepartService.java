package com.jd.service;


import com.jd.bean.Depart;
import java.util.List;

public interface DepartService {

    boolean saveDepart(Depart depart);
    boolean removeDepartById(Integer id);
    boolean modifyDepart(Depart depart);
    Depart getDepartById(int id);
    List<Depart> listAllDeparts();
}
