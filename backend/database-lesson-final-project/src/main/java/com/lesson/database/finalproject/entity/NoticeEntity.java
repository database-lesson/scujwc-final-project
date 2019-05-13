package com.lesson.database.finalproject.entity;

import com.lesson.database.finalproject.entity.base.BaseFinalProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @program: database-lesson-final-project
 * @description: NoticeEntity
 * @author: Vaskka
 * @create: 2019/5/13 11:08 AM
 **/

@Table(name = "notice")
@Entity
@Getter
@Setter
public class NoticeEntity  extends BaseFinalProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @Lob
    @Column(columnDefinition = "text")
    private String content;

    private Timestamp createtime;

    private Timestamp starttime;

    private Timestamp endtime;

    public NoticeEntity(String title, String content, Timestamp createtime, Timestamp starttime, Timestamp endtime) {
        this.title = title;
        this.content = content;
        this.createtime = createtime;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public NoticeEntity() {
    }
}
