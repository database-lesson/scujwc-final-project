package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDao extends JpaRepository<ClassEntity, Integer> {
}
