package com.synthlab.synthlab_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synthlab.synthlab_api.Entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
