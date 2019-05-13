package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.PrereqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrereqDao extends JpaRepository<PrereqEntity, Integer> {
}
