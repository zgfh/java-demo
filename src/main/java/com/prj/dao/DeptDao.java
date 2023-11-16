package com.prj.dao;

import com.prj.bean.DeptMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeptDao extends JpaSpecificationExecutor<DeptMode>, JpaRepository<DeptMode,Long> {

}
