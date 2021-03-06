package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDao extends JpaRepository<NoticeEntity, Integer> {
}
