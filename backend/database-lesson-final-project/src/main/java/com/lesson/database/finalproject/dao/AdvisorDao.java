package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.AdvisorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdvisorDao extends JpaRepository<AdvisorEntity, Integer> {

}
