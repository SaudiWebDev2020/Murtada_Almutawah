package com.mamutawah.overflow.repositories;

import java.util.List;

import com.mamutawah.overflow.models.Answer;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
  public List<Answer> findAll();
}