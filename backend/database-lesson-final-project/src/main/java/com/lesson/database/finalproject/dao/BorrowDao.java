package com.lesson.database.finalproject.dao;

import com.lesson.database.finalproject.entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: database-lesson-final-project
 * @description: BorrowDao
 * @author: Vaskka
 * @create: 2019/5/13 11:30 AM
 **/

@Repository
public interface BorrowDao extends JpaRepository<BorrowEntity, Integer> {


}
