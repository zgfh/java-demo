package com.prj.dao;


import com.prj.bean.EmployeeKpiMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// 实现数据层的增删改查
public interface EmployeeKpiDao extends JpaSpecificationExecutor<EmployeeKpiMode>, JpaRepository<EmployeeKpiMode,String> {

}
