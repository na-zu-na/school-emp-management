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
    //����ҵ������
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        //����ҵ��㣺��¼����
        Emp loginEmp = empService.login(emp);
        //�жϣ���¼�û��Ƿ����
        if(loginEmp !=null ){
            //�Զ�����Ϣ
            Map<String , Object> map = new HashMap<>();
            map.put("id", loginEmp.getId());
            map.put("username",loginEmp.getUsername());
            map.put("name",loginEmp.getName());
            //ʹ��JWT�����࣬�����������
            String token = JwtUtils.generateJwt(map);
            return Result.success(token);
        }
        return Result.error("�û������������");
    }
}