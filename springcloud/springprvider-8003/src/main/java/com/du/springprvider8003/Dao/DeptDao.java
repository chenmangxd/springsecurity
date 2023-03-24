package com.du.springprvider8003.Dao;

import com.du.springcloudapi.pojo.Dept;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

        //添加一个部门
        public boolean addDept(Dept dept);
        //根据id查出一个部门
        public Dept queryById(int id);
        //查询所有部门信息
        public List<Dept> queryAll();
}
