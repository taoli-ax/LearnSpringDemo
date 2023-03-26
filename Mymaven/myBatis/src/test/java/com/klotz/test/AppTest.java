package com.klotz.test;

import com.klotz.dao.DeptDao;
import com.klotz.pojo.Department;
import com.klotz.pojo.DepartmentExpand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public class AppTest {
    @Test
    public void FindAllTest() throws IOException {
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
        List<Department> departments=deptDao.findAll();
        for (Department dept:departments
             ) {
            System.out.println(dept);
        }
    }
    @Test
    public void Save() throws IOException {
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
        int n=deptDao.save(new Department(1,"Sami","Han"));
        sqlSession.commit();
        sqlSession.close();
        System.out.println("insert:"+n);

    }
    @Test
    public void update() throws IOException {
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
        int n=deptDao.update(new Department(1,"Dejo","Han"));
        sqlSession.commit();
        sqlSession.close();
        System.out.println("update:"+n);

    }
    @Test
    public void delete() throws IOException {
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
        deptDao.deleteByName("Sami");
        sqlSession.commit();
        sqlSession.close();


    }
    @Test
    public void countByExpand() throws IOException {
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
        DepartmentExpand departmentExpand=new DepartmentExpand();
        departmentExpand.setNameLike("%D%");
        int n=deptDao.countByExpand(departmentExpand);
        System.out.println("expand: "+n);
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public  void  TestAdd(){
        int a=0;
        int b=1;
        System.out.println(a+b);
    }
}
