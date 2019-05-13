package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: GradeEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:00 AM
 **/

@Table(name = "grade")
@Entity
@Getter
@Setter
public class GradeEntity extends BaseFinalProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer secid;

    private Integer sid;

    private Double num;

    public GradeEntity(Integer secid, Integer sid, Double num) {
        this.secid = secid;
        this.sid = sid;
        this.num = num;
    }

    public GradeEntity() {
    }
}
