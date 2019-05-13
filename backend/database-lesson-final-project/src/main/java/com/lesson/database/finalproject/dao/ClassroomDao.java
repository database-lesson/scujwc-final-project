package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.ClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomDao extends JpaRepository<ClassroomEntity, Integer> {
}
