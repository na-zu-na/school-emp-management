package com.austin.cotroller;

import com.austin.pojo.Emp;
import com.austin.pojo.Result;
import com.austin.service.EmpService;
import com.austin.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    //依赖业务层对象
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        //调用业务层：登录功能
        Emp loginEmp = empService.login(emp);
        //判断：登录用户是否存在
        if(loginEmp !=null ){
            //自定义信息
            Map<String , Object> map = new HashMap<>();
            map.put("id", loginEmp.getId());
            map.put("username",loginEmp.getUsername());
            map.put("name",loginEmp.getName());
            //使用JWT工具类，生成身份令牌
            String token = JwtUtils.generateJwt(map);
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");
    }
}