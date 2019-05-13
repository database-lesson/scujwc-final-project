package com.lesson.database.finalproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @program: database-lesson-final-project
 * @description: ClassEntity
 * @author: Vaskka
 * @create: 2019/5/13 10:50 AM
 **/
@Table(name = "class")
@Entity
@Getter
@Setter
public class ClassEntity extends BaseFinalProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer deptid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp stime;

    private Integer classnum;

    public ClassEntity(Integer deptid, Timestamp stime, Integer classnum) {
        this.deptid = deptid;
        this.stime = stime;
        this.classnum = classnum;
    }

    public ClassEntity() {
    }
}
