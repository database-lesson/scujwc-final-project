package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: DepartmentEntity
 * @author: Vaskka
 * @create: 2019/5/13 10:58 AM
 **/

@Table(name = "department")
@Entity
@Getter
@Setter
public class DepartmentEntity extends BaseFinalProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String deptname;

    private String building;

    public DepartmentEntity(String deptname, String building) {
        this.deptname = deptname;
        this.building = building;
    }


    public DepartmentEntity() {
    }
}
