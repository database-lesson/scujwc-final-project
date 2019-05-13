package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: TimeslotEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:24 AM
 **/

@Table(name = "timeslot")
@Entity
@Getter
@Setter
public class TimeslotEntity extends BaseFinalProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer startweek;

    private Integer endweek;

    private Integer startindex;

    private Integer endindex;

    public TimeslotEntity(Integer startweek, Integer endweek, Integer startindex, Integer endindex) {
        this.startweek = startweek;
        this.endweek = endweek;
        this.startindex = startindex;
        this.endindex = endindex;
    }

    public TimeslotEntity() {
    }
}
