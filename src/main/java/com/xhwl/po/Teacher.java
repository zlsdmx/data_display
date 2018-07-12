package com.xhwl.po;

import javax.persistence.*;

@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "t_id")
    private Integer tId;

    @Column(name = "t_name")
    private String tName;

    /**
     * @return t_id
     */
    public Integer gettId() {
        return tId;
    }

    /**
     * @param tId
     */
    public void settId(Integer tId) {
        this.tId = tId;
    }

    /**
     * @return t_name
     */
    public String gettName() {
        return tName;
    }

    /**
     * @param tName
     */
    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }
}