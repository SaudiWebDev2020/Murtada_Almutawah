package com.mamutawah.overflow.repositories;

import java.util.List;
import java.util.Optional;

import com.mamutawah.overflow.models.Tag;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
  List<Tag> findAll();

  Optional<Tag> findBySubject(String subject);
}
