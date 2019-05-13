package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: CourseEntity
 * @author: Vaskka
 * @create: 2019/5/13 10:56 AM
 **/
@Table(name = "course")
@Entity
@Getter
@Setter
public class CourseEntity extends BaseFinalProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private Integer deptid;

    private Integer credits;

    private String type;

    public CourseEntity(String title, Integer deptid, Integer credits, String type) {
        this.title = title;
        this.deptid = deptid;
        this.credits = credits;
        this.type = type;
    }

    public CourseEntity() {
    }
}
