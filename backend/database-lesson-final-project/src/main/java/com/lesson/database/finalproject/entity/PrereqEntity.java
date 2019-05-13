package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: PrereqEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:12 AM
 **/

@Table(name = "prereq")
@Entity
@Getter
@Setter
public class PrereqEntity extends BaseFinalProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer cid;

    private Integer prereqcid;

    public PrereqEntity(Integer cid, Integer prereqcid) {
        this.cid = cid;
        this.prereqcid = prereqcid;
    }

    public PrereqEntity() {
    }
}
