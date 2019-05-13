package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: database-lesson-final-project
 * @description: SectionEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:15 AM
 **/

@Table(name = "section")
@Entity
@Getter
@Setter
public class SectionEntity extends BaseFinalProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer lessonid;

    private Integer courseid;

    private Integer year;

    private String semester;

    private Integer classroomid;

    private Integer tsid;

    public SectionEntity(Integer lessonid, Integer courseid, Integer year, String semester, Integer classroomid, Integer tsid) {
        this.lessonid = lessonid;
        this.courseid = courseid;
        this.year = year;
        this.semester = semester;
        this.classroomid = classroomid;
        this.tsid = tsid;
    }

    public SectionEntity() {
    }
}

