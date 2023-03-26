package com.klotz.dao;

import com.klotz.pojo.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeptDao {
    @Select("select * from department")
    List<Department> findAll();

    @Insert("insert into department(name,deptNo,loc) values(#{name},#{deptNo},#{loc})")
    int save(Department department);

    @Update("update department set loc=#{loc} where name=#{name}")
    int update(Department department);

    @Delete("delete from department where name=#{name}")
    void deleteByName(String name);

    @Select("select from department where name=#{name}")
    Department findOneByName(String name);
}
