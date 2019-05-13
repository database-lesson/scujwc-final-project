package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionDao extends JpaRepository<SectionEntity, Integer> {

}

