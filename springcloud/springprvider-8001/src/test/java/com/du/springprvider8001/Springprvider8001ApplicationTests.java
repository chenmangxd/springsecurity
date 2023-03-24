package com.du.springprvider8001;

import com.du.springprvider8001.Dao.DeptDao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springprvider8001ApplicationTests {

    @Autowired
    private DeptDao deptDao;
//    @Test
    void contextLoads() {
        System.out.println(deptDao.queryAll());
    }

}
