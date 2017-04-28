package com.kite.joco.greendao3p1.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Mester József on 2017. 01. 09..
 */

@Entity()
public class Person {

    @Id
    private Long id;

    @NotNull
    private String name;

    private Date szuldate;

    @Generated(hash = 1502853577)
    public Person(Long id, @NotNull String name, Date szuldate) {
        this.id = id;
        this.name = name;
        this.szuldate = szuldate;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSzuldate() {
        return this.szuldate;
    }

    public void setSzuldate(Date szuldate) {
        this.szuldate = szuldate;
    }
}
