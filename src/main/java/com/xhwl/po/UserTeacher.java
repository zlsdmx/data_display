package com.xhwl.po;

import javax.persistence.*;

@Table(name = "user_teacher")
public class UserTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "u_name")
    private String uName;

    @Column(name = "t_name")
    private String tName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return u_name
     */
    public String getuName() {
        return uName;
    }

    /**
     * @param uName
     */
    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
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