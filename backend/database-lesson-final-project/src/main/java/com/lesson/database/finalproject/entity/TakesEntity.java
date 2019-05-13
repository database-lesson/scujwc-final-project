package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: TakesEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:22 AM
 **/

@Table(name = "takes")
@Entity
@Getter
@Setter
public class TakesEntity extends BaseFinalProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer sid;

    private Integer secid;

    public TakesEntity(Integer sid, Integer secid) {
        this.sid = sid;
        this.secid = secid;
    }

    public TakesEntity() {
    }
}
