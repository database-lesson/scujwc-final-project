package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: ClassroomEntity
 * @author: Vaskka
 * @create: 2019/5/13 10:54 AM
 **/

@Table(name = "classroom")
@Entity
@Getter
@Setter
public class ClassroomEntity extends BaseFinalProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String building;

    private String roomnum;

    private Integer capacity;

    public ClassroomEntity(String building, String roomnum, Integer capacity) {
        this.building = building;
        this.roomnum = roomnum;
        this.capacity = capacity;
    }

    public ClassroomEntity() {
    }
}
