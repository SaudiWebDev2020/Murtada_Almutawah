package com.mamutawah.overflow.repositories;

import java.util.List;

import com.mamutawah.overflow.models.Question;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
  public List<Question> findAll();
}
