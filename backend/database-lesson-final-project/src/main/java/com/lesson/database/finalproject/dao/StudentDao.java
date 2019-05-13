package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: database-lesson-final-project
 * @description: StudentDao
 * @author: Vaskka
 * @create: 2019/5/13 11:37 AM
 **/

@Repository
public interface StudentDao extends JpaRepository<StudentEntity, Integer> {
}
