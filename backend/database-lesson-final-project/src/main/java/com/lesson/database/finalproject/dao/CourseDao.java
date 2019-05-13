package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<CourseEntity, Integer> {

}
