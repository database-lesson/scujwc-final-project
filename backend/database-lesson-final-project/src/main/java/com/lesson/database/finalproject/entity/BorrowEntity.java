package com.lesson.database.finalproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @program: database-lesson-final-project
 * @description: BorrowEntity
 * @author: Vaskka
 * @create: 2019/5/13 10:46 AM
 **/
@Table(name = "borrow")
@Entity
@Getter
@Setter
public class BorrowEntity extends BaseFinalProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer sid;

    private String book;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp stime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp etime;

    public BorrowEntity(Integer sid, String book, Timestamp stime, Timestamp etime) {
        this.sid = sid;
        this.book = book;
        this.stime = stime;
        this.etime = etime;
    }

    public BorrowEntity() {
    }
}
