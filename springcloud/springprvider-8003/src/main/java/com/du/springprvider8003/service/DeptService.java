package com.du.springprvider8003.service;

import com.du.springcloudapi.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);

    //根据id查询部门信息
    Dept queryById(int id);

    //查询所有的部门信息
    List<Dept> queryAll();
}
