package com.prj.controller;

import com.prj.bean.DeptMode;
import com.prj.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "dept")
public class DeptController {

    @Autowired
    DeptDao deptDao;

    @GetMapping()
    public Page<DeptMode> getall(@PageableDefault(page=0,sort = {"name"},direction = Sort.Direction.DESC)Pageable pageable){
        Page<DeptMode> data = deptDao.findAll(pageable);
        return data;
    }

    @PostMapping()
    public DeptMode create(@RequestBody DeptMode deptMode){
        DeptMode newdeptMode = deptDao.save(deptMode);
        return newdeptMode;
    }

    @PutMapping("/{id}")
    public DeptMode update(@PathVariable String id,@RequestBody DeptMode deptMode){
        deptMode.setId(id);
        DeptMode newdeptMode = deptDao.save(deptMode);
        return newdeptMode;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        deptDao.deleteById(id);
    }


}
