package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.JpaPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<JpaPost, Integer> {
}
