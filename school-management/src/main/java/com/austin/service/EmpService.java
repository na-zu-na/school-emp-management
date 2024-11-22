package com.austin.service;

import com.austin.pojo.Emp;
import com.austin.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short
            gender, LocalDate begin, LocalDate end);

    void delet(List<Integer> ids);

    void add(Emp emp);

    Emp get(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
