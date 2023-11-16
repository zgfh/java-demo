package com.prj.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "dept")
public class DeptMode {
    @Id
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name = "system_uuid",strategy = "uuid")
    private String id;
    private String name;

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
}
