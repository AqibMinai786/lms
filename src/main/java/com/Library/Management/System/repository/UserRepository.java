package com.Library.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Library.Management.System.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
