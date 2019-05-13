package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: TeachesEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:23 AM
 **/

@Table(name = "teaches")
@Entity
@Getter
@Setter
public class TeachesEntity extends BaseFinalProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer secid;

    private Integer iid;

    public TeachesEntity(Integer secid, Integer iid) {
        this.secid = secid;
        this.iid = iid;
    }

    public TeachesEntity() {
    }
}
