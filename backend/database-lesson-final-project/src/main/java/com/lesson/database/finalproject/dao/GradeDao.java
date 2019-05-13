package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeDao extends JpaRepository<GradeEntity, Integer> {
}
