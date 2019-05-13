package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDao extends JpaRepository<InstructorEntity, Integer> {

}

