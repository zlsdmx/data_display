package com.xhwl.po;

import java.util.List;

import javax.persistence.*;

@Table(name = "group")
public class Group {
    @Id
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_name")
    private String cName;

    /**
     * class表中有一个teacher_id字段，所以在Classes类中定义一个teacher属性，
     * 用于维护teacher和class之间的一对一关系，通过这个teacher属性就可以知道这个班级是由哪个老师负责的
     */
    @Transient
    private Teacher teacher;

    // 使用一个List<Student>集合属性表示班级拥有的学生
    @Transient
    private List<Student> students;
    
    /*public Group() {
        super();
    }

    public Group(Integer id, String cName, Teacher teacher, List<Student> students) {
        super(); 
        this.id = id;
        this.cName = cName;
        this.teacher = teacher;
        this.students = students;
    }
*/
    /**
     * @return c_id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param cId
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return c_name
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName
     */
    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group [id=" + id + ", cName=" + cName + ", teacher=" + teacher + ", students=" + students + "]";
    }
    
    
}