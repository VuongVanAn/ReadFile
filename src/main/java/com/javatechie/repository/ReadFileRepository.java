package com.javatechie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.model.User;

public interface ReadFileRepository extends JpaRepository<User, Integer> {

}
