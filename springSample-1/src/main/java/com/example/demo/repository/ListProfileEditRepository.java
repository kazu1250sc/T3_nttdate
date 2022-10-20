package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Private_user;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface ListProfileEditRepository extends JpaRepository<Private_user, Long> {
	
}