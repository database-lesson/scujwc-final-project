package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentEntity, Integer> {
}
