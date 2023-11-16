package com.prj.dao;


import com.prj.bean.EmployeeMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// 实现数据层的增删改查
public interface EmployeeDao extends JpaSpecificationExecutor<EmployeeMode>, JpaRepository<EmployeeMode,String> {

}
