package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: AdvisorEntity
 * @author: Vaskka
 * @create: 2019/5/13 10:40 AM
 **/

@Table(name = "advisor")
@Entity
@Getter
@Setter
public class AdvisorEntity extends BaseFinalProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer iid;

    private Integer sid;

    public AdvisorEntity(Integer iid, Integer sid) {
        this.iid = iid;
        this.sid = sid;
    }

    public AdvisorEntity() {
    }
}
