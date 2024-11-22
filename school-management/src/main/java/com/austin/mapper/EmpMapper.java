package com.austin.mapper;

import com.austin.pojo.Emp;
import com.austin.pojo.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //获取当前页结果，使用xml映射文件
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    @Delete("delete from emp where id=#{id}")
    void delete(Integer id);

    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time,password) values (#{username}, #{name}, #{gender}, #{image},#{job},#{entrydate}, #{deptId}, #{createTime}, #{updateTime},#{password});")
    void add(Emp emp);

    @Select(("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id = #{id}"))
    Emp get(Integer id);

    //使用xml映射文件
    void update(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp login(Emp emp);
}
