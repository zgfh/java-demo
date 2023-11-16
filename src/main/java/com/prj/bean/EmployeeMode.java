package com.prj.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeMode {
    @Id
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name = "system_uuid",strategy = "uuid")

    private String id;//部门编号

    private String name;//名字

    private String dept;//所在部门

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "dept", referencedColumnName = "name",insertable = false,updatable = false)
    private DeptMode deptMode;
    private String position;//职位
    private Float salary;//薪资

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public DeptMode getDeptMode() {
        return deptMode;
    }

    public void setDeptMode(DeptMode deptMode) {
        this.deptMode = deptMode;
    }
}
