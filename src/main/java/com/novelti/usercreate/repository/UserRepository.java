package com.novelti.usercreate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novelti.usercreate.entity.UserCreate;


public interface UserRepository extends JpaRepository<UserCreate, Long> {

}
 