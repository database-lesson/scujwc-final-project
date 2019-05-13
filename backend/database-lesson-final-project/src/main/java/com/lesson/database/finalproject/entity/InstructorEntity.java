package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: InstructorEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:06 AM
 **/

@Table(name = "instructor")
@Entity
@Getter
@Setter
public class InstructorEntity  extends BaseFinalProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer deptid;

    private Double salary;

    public InstructorEntity(String name, Integer deptid, Double salary) {
        this.name = name;
        this.deptid = deptid;
        this.salary = salary;
    }

    public InstructorEntity() {
    }
}
