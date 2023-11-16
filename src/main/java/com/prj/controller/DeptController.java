package com.prj.controller;

import com.prj.bean.DeptMode;
import com.prj.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeptController {

    @Autowired
    DeptDao deptDao;

    @GetMapping("/test")
    public List<DeptMode> test(){
        List<DeptMode> data = deptDao.findAll();
        Map<String, Object> result=new HashMap<>() ;
        result.put("test","ok");
        return data;
    }
}
