package com.prj.controller;

import com.prj.bean.EmployeeKpiMode;
import com.prj.bean.EmployeeKpiMode;
import com.prj.bean.EmployeeMode;
import com.prj.dao.EmployeeDao;
import com.prj.dao.EmployeeKpiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;

@RestController
@RequestMapping(value = "employee_kpi")
//API 实现
public class EmployeeKpiController {

    @Autowired
    EmployeeKpiDao employeeKpiDao;

    @GetMapping()
    //根据员工编号、员工姓名和当年 KPI 值等关键字实现模 糊查询
    public Page<EmployeeKpiMode> getall(@PageableDefault(page=0,sort = {"employeeid"},direction = Sort.Direction.DESC)Pageable pageable, @RequestParam(defaultValue = "") String q){
        Page<EmployeeKpiMode> data = employeeKpiDao.findAll(new Specification<EmployeeKpiMode>() {
            @Override
            public Predicate toPredicate(Root<EmployeeKpiMode> root, CriteriaQuery<?> query, CriteriaBuilder cBuilder) {
                Predicate p=cBuilder.conjunction();
                if (!q.isEmpty()){
                    p=cBuilder.and(p,cBuilder.or(cBuilder.like(root.get("employeeMode").get("position"),q),cBuilder.like(root.get("kpi"),q),cBuilder.like(root.get("employeeid"),q)));
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
    public EmployeeKpiMode create(@RequestBody EmployeeKpiMode employeeKpiMode){
        EmployeeKpiMode newemployeeKpiMode = employeeKpiDao.save(employeeKpiMode);
        return newemployeeKpiMode;
    }

    @PutMapping("/{id}")
    public EmployeeKpiMode update(@PathVariable String id,@RequestBody EmployeeKpiMode employeeKpiMode){
        employeeKpiMode.setId(id);
        EmployeeKpiMode newemployeeKpiMode = employeeKpiDao.save(employeeKpiMode);
        return newemployeeKpiMode;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        employeeKpiDao.deleteById(id);
    }


}
