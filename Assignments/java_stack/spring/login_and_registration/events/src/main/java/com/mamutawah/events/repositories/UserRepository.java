package com.mamutawah.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.mamutawah.events.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByEmail(String email);

  List<User> findAll();
}
