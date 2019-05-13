package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: StudentEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:19 AM
 **/

@Table(name = "student")
@Entity
@Getter
@Setter
public class StudentEntity extends BaseFinalProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String studentnum;

    private String name;

    private Integer deptid;

    private Integer crednum;

    private Integer comeyear;

    private Integer classid;

    private String email;

    // 修读方向
    private String way;

    public StudentEntity(String studentnum, String name, Integer deptid, Integer crednum, Integer comeyear, Integer classid, String email, String way) {
        this.studentnum = studentnum;
        this.name = name;
        this.deptid = deptid;
        this.crednum = crednum;
        this.comeyear = comeyear;
        this.classid = classid;
        this.email = email;
        this.way = way;
    }

    public StudentEntity() {
    }
}