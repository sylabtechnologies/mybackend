package com.dennis.mybackend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dennis.mybackend.model.Userr;

@Repository
public interface UserRepo extends CrudRepository<Userr, Long>{}
