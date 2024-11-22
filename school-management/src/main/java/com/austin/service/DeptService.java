package com.austin.service;

import com.austin.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(int id);

    void adddept(Dept dept);

    void update(Dept dept);
}
