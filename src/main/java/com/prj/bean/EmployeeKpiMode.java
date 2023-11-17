package com.prj.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_kpi")
public class EmployeeKpiMode implements Serializable {
    @Id
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name = "system_uuid",strategy = "uuid")
    private String id;//部门编号

    private String employeeid;//员工编号
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeid", referencedColumnName = "id",insertable = false,updatable = false)
    private EmployeeMode employeeMode;

    private String leader;//评价人
    private String kpi;//当年考核值
    private Float comments;//评价意见
    private Float check_date;//考核时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getKpi() {
        return kpi;
    }

    public void setKpi(String kpi) {
        this.kpi = kpi;
    }

    public Float getComments() {
        return comments;
    }

    public void setComments(Float comments) {
        this.comments = comments;
    }

    public Float getCheck_date() {
        return check_date;
    }

    public void setCheck_date(Float check_date) {
        this.check_date = check_date;
    }

    public EmployeeMode getEmployeeMode() {
        return employeeMode;
    }

    public void setEmployeeMode(EmployeeMode employeeMode) {
        this.employeeMode = employeeMode;
    }
}
