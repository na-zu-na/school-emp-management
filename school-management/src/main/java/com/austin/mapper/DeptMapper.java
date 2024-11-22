package com.austin.mapper;

import com.austin.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from dept")
    List<Dept> list();

    @Delete("delete from dept where id=#{id}")
    void delete(int id);

    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void adddept(Dept dept);

    @Update("update dept set name=#{name} where id=#{id}")
    void update(Dept dept);
}
