package com.prj.controller;

import com.prj.bean.DeptMode;
import com.prj.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "dept")
//API 实现
public class DeptController {

    @Autowired
    DeptDao deptDao;

    @GetMapping()
    //提供根据部门编、部门经理和部门名字等关键字进行模糊 查询的功能
    public Page<DeptMode> getall(@PageableDefault(page=0,sort = {"name"},direction = Sort.Direction.DESC)Pageable pageable,@RequestParam(defaultValue = "") String q){
        Page<DeptMode> data = deptDao.findAll(new Specification<DeptMode>() {
            @Override
            public Predicate toPredicate(Root<DeptMode> root, CriteriaQuery<?> query, CriteriaBuilder cBuilder) {
                Predicate p=cBuilder.conjunction();
                if (!q.isEmpty()){
                    p=cBuilder.and(p,cBuilder.or(cBuilder.like(root.get("name"),q),cBuilder.like(root.get("manager"),q),cBuilder.like(root.get("id"),q)));
                }

                return p;
            }
        }, pageable);
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
