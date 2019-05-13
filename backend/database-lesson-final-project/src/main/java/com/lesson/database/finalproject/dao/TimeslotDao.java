package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.TimeslotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeslotDao extends JpaRepository<TimeslotEntity, Integer> {
}
