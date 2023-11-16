package com.prj.controller;

import com.prj.bean.EmployeeMode;
import com.prj.bean.EmployeeMode;
import com.prj.dao.DeptDao;
import com.prj.dao.EmployeeDao;
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

@RestController
@RequestMapping(value = "employee")
//API 实现
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping()
    //员工编号、员工姓名、员工所在部门、员工职位 和员工薪资等关键字进行模糊查询的功能
    public Page<EmployeeMode> getall(@PageableDefault(page=0,sort = {"name"},direction = Sort.Direction.DESC)Pageable pageable, @RequestParam(defaultValue = "") String q){
        Page<EmployeeMode> data = employeeDao.findAll(new Specification<EmployeeMode>() {
            @Override
            public Predicate toPredicate(Root<EmployeeMode> root, CriteriaQuery<?> query, CriteriaBuilder cBuilder) {
                Predicate p=cBuilder.conjunction();
                if (!q.isEmpty()){
                    p=cBuilder.and(p,cBuilder.or(cBuilder.like(root.get("salary"),q),cBuilder.like(root.get("position"),q),cBuilder.like(root.get("name"),q),cBuilder.like(root.get("dept"),q),cBuilder.like(root.get("id"),q)));
                    //大于等于开始时间
                    //p=cBuilder.and(p,cBuilder.greaterThanOrEqualTo(root.get("createTime"),beginDate));
                    //小于等于开始时间
                    //p=cBuilder.and(p,cBuilder.lessThanOrEqualTo(root.get("createTime"),beginDate));
                }

                return p;
            }
        }, pageable);
        return data;
    }

    @PostMapping()
    public EmployeeMode create(@RequestBody EmployeeMode employeeMode){
        EmployeeMode newemployeeMode = employeeDao.save(employeeMode);
        return newemployeeMode;
    }

    @PutMapping("/{id}")
    public EmployeeMode update(@PathVariable String id,@RequestBody EmployeeMode employeeMode){
        employeeMode.setId(id);
        EmployeeMode newemployeeMode = employeeDao.save(employeeMode);
        return newemployeeMode;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        employeeDao.deleteById(id);
    }


}
