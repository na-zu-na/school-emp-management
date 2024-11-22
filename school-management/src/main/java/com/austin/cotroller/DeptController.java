package com.austin.cotroller;

import com.austin.pojo.Dept;
import com.austin.pojo.Result;
import com.austin.service.DeptService;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {
    private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result getDepts() {
        log.info("select all depts");
        //调用service层
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable int id) {
        log.info("delete dept by id: {}", id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept) {
        log.info("add dept : {}", dept);
        deptService.adddept(dept);
        return Result.success();
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        log.info("update dept : {}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
