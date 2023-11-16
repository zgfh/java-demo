package com.prj.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dept")
public class DeptMode implements Serializable {
    @Id
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name = "system_uuid",strategy = "uuid")
    private String id;//编号
    private String manager;//部门经理
    private String name;//部门名字

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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
